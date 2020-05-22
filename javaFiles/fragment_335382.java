public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

private static final String TAG = "com.mypackage.inappbilling";

  public static final String ITEM_SKU = "test2";

NavigationView navigationView = null;
Toolbar toolbar = null;
IabHelper mHelper;
 boolean mIsPremium = false;
boolean mIsUserPremium = false;
boolean searchAllowed = false;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

    SharedPreferences prefs = getSharedPreferences(
            "com.xxxxxx", 0);
    mIsPremium = prefs.getBoolean("premium", false);




    if (mIsPremium) {

        MainFragmentDisAd fragment = new MainFragmentDisAd();

        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        } else {
        MainFragment fragment = new MainFragment();

        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


   //InAppBilling

   String base64EncodedPublicKey = "@string/base64";
   // compute your public key and store it in base64EncodedPublicKey
    mHelper = new IabHelper(this, base64EncodedPublicKey);

     mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
                       @SuppressLint("LongLogTag")
                       public void onIabSetupFinished(IabResult     result) {
                                   if (!result.isSuccess()) {
                                       // Oh no, there was a problem.
                   Log.d(TAG, "Problem setting up In-app Billing: " + result);

                                   }

                // Hooray, IAB is fully set up. Now, let's get an inventory of

               Log.d(TAG, "Setup successful. Querying inventory.");
          mHelper.queryInventoryAsync(mGotInventoryListener);


                               }
                           }
          });
           }


           @Override
        protected void onActivityResult(int requestCode, int resultCode,
                            Intent data)
      {
        if (!mHelper.handleActivityResult(requestCode,
        resultCode, data)) {
    super.onActivityResult(requestCode, resultCode, data);
     }
     }

        IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
       = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result,
                                  Purchase purchase)
     {
    if (result.isFailure()) {

        // Handle error
        return;
    }
    if (!verifyDeveloperPayload(purchase)) {
            complain("Erreur lors de l'achat. Authentification non reconnue.");

            return;

        }
        Log.d(TAG, "Purchase successful.");

        if (purchase.getSku().equals(ITEM_SKU)) {
            // bought the premium upgrade!
            Log.d(TAG, "It's ok.");
            alert("You are premiul");
            mIsPremium = true;
            SharedPreferences prefs = getBaseContext().getSharedPreferences(
                    "com.xxxxx", 0);
            prefs.edit().putBoolean("premium", true).apply();


         }
       };



       public void consumeItem() {
      mHelper.queryInventoryAsync(mReceivedInventoryListener);
   }

      IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new      IabHelper.QueryInventoryFinishedListener() {
    @SuppressLint("LongLogTag")
    @Override
    public void onQueryInventoryFinished(IabResult result,
                                         Inventory inventory) {
        Log.d(TAG, "Inventory is finish.");
        if (result.isFailure()) {
            complain("Echec" + result);

            return;
        }

    /*if (inventory.hasPurchase(PREM_SKU)) {

        mHelper.consumeAsync(inventory.getPurchase(PREM_SKU), null);
    }*/

        Log.d(TAG, "Inventory is ok.");


        Purchase premiumPurchase = inventory.getPurchase(ITEM_SKU);
        mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
        Log.d(TAG, "User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));
        if (mIsPremium) {
            searchAllowed = true;
            mIsUserPremium = true;
            Log.d(TAG, "you must be premium...");
            SharedPreferences prefs = getBaseContext().getSharedPreferences(
                    "com.xxxx", 0);
            prefs.edit().putBoolean("premium", true).apply();


        }

        Log.d(TAG, "Initial inventory query finished; enabling main UI.");


    }


     };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
    new IabHelper.OnConsumeFinishedListener() {
        public void onConsumeFinished(Purchase purchase,
                                      IabResult result) {

        }
    };



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
     public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
     int id = item.getItemId();

    if (id == R.id.nav_agenda) {


        if (mIsPremium) {

            MainFragmentDisAd fragment = new MainFragmentDisAd();

            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else {
            MainFragment fragment = new MainFragment();

            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }
} else if (id == R.id.nav_cadena) {

    mHelper.launchPurchaseFlow(this, ITEM_SKU, 10001,
            mPurchaseFinishedListener, "mypurchasetoken");


} else if (id == R.id.nav_apropos) {
    //Set the fragment initially
    AproposFragment fragment = new AproposFragment();
    android.support.v4.app.FragmentTransaction fragmentTransaction =
            getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.fragment_container, fragment);
    fragmentTransaction.commit();

} 

   @Override
  public void onDestroy() {
super.onDestroy();
if (mHelper != null) mHelper.dispose();
mHelper = null;
 }