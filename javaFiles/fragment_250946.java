protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    checkPermissions();
    intentInfo();   // NOT GOOD HERE.
}

private void intentInfo() {
    try{
        ......
        String type = this.getIntent().getStringExtra("type");
        // if type is display just display the route
        // if track then display the eta and current status
        if(Objects.equals(type, "track")) {
            String location = this.getIntent().getStringExtra("location");
             track_my_ride(location); // You're gonna NPE HERE.
        }
    }
    catch (Error e) {
        Log.e("ViewMapActivity.class", "intentInfo: ", e);  // You're gonna NPE catch  HERE.
    }
}