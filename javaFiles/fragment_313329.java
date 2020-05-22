//detect internet and show the data
    if(isNetworkStatusAvialable (getApplicationContext())) {
        Toast.makeText(getApplicationContext(), "Internet detected", Toast.LENGTH_SHORT).show();
        new FetchWebsiteData().execute();
    } else {
        Toast.makeText(getApplicationContext(), "Please check your Internet Connection", Toast.LENGTH_SHORT).show();

    }