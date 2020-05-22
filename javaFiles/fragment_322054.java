public void inCaseOffline() {

    StoreHelper sh = new StoreHelper(ctx);
    Log.i("ncdebug", "Store ID(incaseoffline): " + storeid);
    StoreData sd = sh.getStore(storeid);

    // Add the null checking
    if(sd == null) {
        Toast.makeText(YourActivity.this, "Could not fetch information", Toast.LENGTH_LONG).show();
        return;
    }

    // .. Your code
}