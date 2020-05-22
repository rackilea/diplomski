public void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 

    // ... 

    progressBar = ProgressDialog.show(Places.this, "", "Loading Page...");

    if (isGeolocationAvailable()) {
       Android20Util.enableGeolocation(webview);
    }        
}