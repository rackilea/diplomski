ConnectivityManager cm = 
        (ConnectivityManager) Context.getSystemService(Context.CONNECTIVITY_SERVICE);

NetworkRequest request = new NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build();

cm.requestNetwork(request,
                  new ConnectivityManager.NetworkCallback() {
                      void onAvailable(Network network) {
                         // Do something once the network is available
                      }
                  });