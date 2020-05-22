package in.kpis.nearyou.base;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.android.vending.billing.IInAppBillingService;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import in.kpis.nearyou.entity.AvailablePurchase;
import in.kpis.nearyou.entity.Helper;
import in.kpis.nearyou.entity.PurchaseResponseBean;
import in.kpis.nearyou.entity.UserPurchaseItemsBean;
import in.kpis.nearyou.utilities.AppPreference;

import static in.kpis.nearyou.base.BaseInAppPurchaseActivity.ConsuptionResponseType.SUCCESS;
import static in.kpis.nearyou.base.BaseInAppPurchaseActivity.PurchaseStateTypes.PURCHASED;


public class BaseInAppPurchaseActivity extends BaseAppCompatActivity {
    private static final String TAG = BaseInAppPurchaseActivity.class.getSimpleName();
    private IInAppBillingService mService;


    private static final char[] symbols = new char[36];

    static {
        for (int idx = 0; idx < 10; ++idx)
            symbols[idx] = (char) ('0' + idx);
        for (int idx = 10; idx < 36; ++idx)
            symbols[idx] = (char) ('a' + idx - 10);
    }

    public void startInAppPurchaseServices() {
        Intent serviceIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        serviceIntent.setPackage("com.android.vending");
        bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE);
    }

    private String appPackageName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appPackageName = this.getPackageName();
        startInAppPurchaseServices();
    }

    ServiceConnection mServiceConn = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IInAppBillingService.Stub.asInterface(service);
            startAsyncForCheckingAvailablePurchase();
        }
    };

    private void startAsyncForCheckingAvailablePurchase() {
        if (skuListByNearyouServer != null && skuListByNearyouServer.size() > 0 & onResultInApp != null) {
            AvailablePurchaseAsyncTask mAsyncTask = new AvailablePurchaseAsyncTask(appPackageName, skuListByNearyouServer, onResultInApp);
            mAsyncTask.execute();
        }
    }

    private ArrayList<String> skuListByNearyouServer = new ArrayList<>();
    OnResultInApp onResultInApp;

    public void checkAvailablePurchases(ArrayList<String> skuList, OnResultInApp onResultInApp) {
        skuListByNearyouServer = skuList;
        this.onResultInApp = onResultInApp;

        if (mService == null) startInAppPurchaseServices();
        else startAsyncForCheckingAvailablePurchase();
    }


    public interface OnResultPurchase {
        void onSuccess(PurchaseResponseBean purchaseResponseBean, String inAppPurchaseData);

        void onError();
    }

    private OnResultPurchase onResultPurchase;
    private String itemToPurchaseSku;

    public void purchaseItem(String sku, OnResultPurchase onResultPurchase) {
        this.onResultPurchase = onResultPurchase;
        itemToPurchaseSku = sku;
        if (isBillingSupported()) {
            String generatedPayload = getPayLoad();
            AppPreference.getInstance(BaseInAppPurchaseActivity.this).setDeveloperPayload(generatedPayload);
            try {
                Bundle buyIntentBundle = mService.getBuyIntent(3, getPackageName(), sku, "inapp", generatedPayload);
                PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), Helper.RESPONSE_CODE, new Intent(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Helper.RESPONSE_CODE) {
            if (data != null && data.getExtras() != null && data.getStringExtra("INAPP_DATA_SIGNATURE") != null & data.getStringExtra("INAPP_PURCHASE_DATA") != null) {

                int responseCode = data.getIntExtra("RESPONSE_CODE", 0);
                String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
                String dataSignature = data.getStringExtra("INAPP_DATA_SIGNATURE");
                if (resultCode == RESULT_OK && responseCode == 0) {
                    try {
                        PurchaseResponseBean purchaseResponseBean = new Gson().fromJson(purchaseData, PurchaseResponseBean.class);
                        String sku = purchaseResponseBean.getProductId();
                        String developerPayload = purchaseResponseBean.getDeveloperPayload();
                        int responseCodeConsuption = consumePurchaseItem(purchaseResponseBean.getPurchaseToken());
                        if (responseCodeConsuption == SUCCESS) {
                            if (purchaseResponseBean.getPurchaseState() == PURCHASED && itemToPurchaseSku.equals(sku) && developerPayload.equals(AppPreference.getInstance(BaseInAppPurchaseActivity.this).getDeveloperPayload())) {
                                if (onResultPurchase != null)
                                    onResultPurchase.onSuccess(purchaseResponseBean, purchaseData);
                            } else onErrorOfPurchase();
                        } else onResultPurchase.onSuccess(purchaseResponseBean, purchaseData);
                    } catch (Exception e) {
                        e.printStackTrace();
                        onErrorOfPurchase();
                    }
                } else onErrorOfPurchase();
            }
        } else onErrorOfPurchase();
    }

    private void onErrorOfPurchase() {
        if (onResultPurchase != null) onResultPurchase.onError();
    }

    interface PurchaseStateTypes {
        int PURCHASED = 0;
        int CANCELED = 1;
        int REFUNDED = 2;

    }

    interface ConsuptionResponseType {
        int SUCCESS = 0;
    }


    private String getPayLoad() {
        RandomString randomString = new RandomString(36);
        String payload = randomString.nextString();
        return payload;
    }

    private class RandomString {
        private final Random random = new Random();
        private final char[] buf;

        RandomString(int length) {
            if (length < 1)
                throw new IllegalArgumentException("length < 1: " + length);
            buf = new char[length];
        }

        String nextString() {
            for (int idx = 0; idx < buf.length; ++idx)
                buf[idx] = symbols[random.nextInt(symbols.length)];
            return new String(buf);
        }
    }

    public final class SessionIdentifierGenerator {
        private SecureRandom random = new SecureRandom();

        public String nextSessionId() {
            return new BigInteger(130, random).toString(32);
        }
    }

    public interface OnResultInApp {
        void onResult(ArrayList<AvailablePurchase> canPurchaseList);
    }

    private class AvailablePurchaseAsyncTask extends AsyncTask<Void, Void, Bundle> {
        String packageName;
        ArrayList<String> skuList;
        OnResultInApp OnResultInApp;

        AvailablePurchaseAsyncTask(String packageName, ArrayList<String> skuList, OnResultInApp OnResultInApp) {
            this.packageName = packageName;
            this.skuList = skuList;
            this.OnResultInApp = OnResultInApp;
        }

        @Override
        protected Bundle doInBackground(Void... voids) {

            Bundle query = new Bundle();
            query.putStringArrayList(Helper.ITEM_ID_LIST, skuList);
            Bundle skuDetails = null;
            try {
                skuDetails = mService.getSkuDetails(3, packageName, "inapp", query);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            return skuDetails;
        }

        @Override
        protected void onPostExecute(Bundle skuDetails) {
            ArrayList<AvailablePurchase> availablePurchaseArrayList = new ArrayList<>();
            if (skuDetails != null) {
                int response = skuDetails.getInt("RESPONSE_CODE");
                if (response == 0) {
                    ArrayList<String> responseList = skuDetails.getStringArrayList("DETAILS_LIST");
                    if (responseList != null) {
                        for (String thisResponse : responseList) {
                            JSONObject object = null;
                            try {
                                object = new JSONObject(thisResponse);
                                String sku = object.getString("productId");
                                String price = object.getString("price");
                                availablePurchaseArrayList.add(new AvailablePurchase(sku, price, false));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            for (AvailablePurchase availablePurchase : availablePurchaseArrayList) {
                for (String sku : skuList) {
                    if (sku.equals(availablePurchase.getSku())) {
                        availablePurchase.setActive(true);
                    }
                }
            }

            if (OnResultInApp != null) {
                OnResultInApp.onResult(availablePurchaseArrayList);
            }
        }
    }


    public boolean isBillingSupported() {
        int response = 1;
        try {
            response = mService.isBillingSupported(3, getPackageName(), "inapp");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (response > 0) {
            return false;
        }
        return true;
    }

    public int consumePurchaseItem(String purchaseToken) {
        if (isBillingSupported()) {
            try {
                int response = mService.consumePurchase(3, getPackageName(), purchaseToken);
                return response;
            } catch (RemoteException e) {
                e.printStackTrace();
                return -1;
            }
        } else return -1;
    }

    public Bundle getAllUserPurchase() {
        Bundle ownedItems = null;
        try {
            ownedItems = mService.getPurchases(3, getPackageName(), "inapp", null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return ownedItems;
    }

    public List<UserPurchaseItemsBean> extractAllUserPurchase(Bundle ownedItems) {
        List<UserPurchaseItemsBean> mUserItems = new ArrayList<UserPurchaseItemsBean>();
        int response = ownedItems.getInt("RESPONSE_CODE");
        if (response == 0) {
            ArrayList<String> ownedSkus = ownedItems.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> purchaseDataList = ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> signatureList = ownedItems.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            String continuationToken = ownedItems.getString("INAPP_CONTINUATION_TOKEN");
            if (purchaseDataList != null) {
                for (int i = 0; i < purchaseDataList.size(); ++i) {
                    String purchaseData = purchaseDataList.get(i);
                    assert signatureList != null;
                    String signature = signatureList.get(i);
                    assert ownedSkus != null;
                    String sku = ownedSkus.get(i);
                    UserPurchaseItemsBean allItems = new UserPurchaseItemsBean(sku, purchaseData, signature);
                    mUserItems.add(allItems);
                }
            }
        }
        return mUserItems;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopInAppPurchaseService();

    }

    private void stopInAppPurchaseService() {
        if (mService != null) {
            unbindService(mServiceConn);
        }
    }
}