public class AvailableCards extends Activity {

IInAppBillingService mService;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_available_cards);
    String packagename = this.getPackageName();
    TextView priceView = (TextView)findViewById(R.id.availablePrice);

    ServiceConnection mServiceConn = new ServiceConnection() {
       @Override
       public void onServiceDisconnected(ComponentName name) {
           mService = null;
       }

       @Override
       public void onServiceConnected(ComponentName name,
          IBinder service) {
           mService = IInAppBillingService.Stub.asInterface(service);
           new GetItemList(packagename, priceView).execute();
       }
    };

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.available_cards, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
}
}

class GetItemList extends AsyncTask<Integer, Integer, Long> {

private String pName;
private TextView pView;

GetItemList(String packagename, TextView priceView){
    pName = packagename;
    pView = priceView;
}

@Override
protected Long doInBackground(Integer... params) {
    ArrayList<String> skuList = new ArrayList<String> ();
    skuList.add("i001");
    skuList.add("i002");
    Bundle querySkus = new Bundle();
    querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
    Bundle skuDetails = null;
    try {
        skuDetails = mService.getSkuDetails(3, pName, "inapp", querySkus);
        int response = skuDetails.getInt("RESPONSE_CODE");
        if (response == 0) {
           ArrayList<String> responseList
              = skuDetails.getStringArrayList("DETAILS_LIST");
           for (String thisResponse : responseList) {
              JSONObject object;
              object = new JSONObject(thisResponse);
              String sku = object.getString("productId");
              String price = object.getString("price");
              String mFirstIntermediate;
              String mSecondIntermediate;
            if (sku.equals("i001")) mFirstIntermediate = price;
              else if (sku.equals("i002")) mSecondIntermediate = price;
            pView.setText(sku + ": " + price);
           }
        }
    } catch (NullPointerException ne)  {
        Log.d("Synch Billing", "Error Null Pointer: " + ne.getMessage());
        ne.printStackTrace();
    }
    catch (RemoteException e) {
        // TODO Auto-generated catch block
        Log.d("Synch Billing", "Error Remote: " + e.getMessage());
        e.printStackTrace();
    }
    catch (JSONException je) {
        // TODO Auto-generated catch block
        Log.d("Synch Billing", "Error JSON: " + je.getMessage());
        je.printStackTrace();
    }
    return null;
}
}