// true when there is no connectivity whatsoever
boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

// lots of extra info & detailed state about the connection
// see http://developer.android.com/reference/android/net/NetworkInfo.html   
NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);

NetworkInfo otherNetworkInfo = (NetworkInfo)intent.getParcelableExtra(ConnectivityManager.EXTRA_OTHER_NETWORK_INFO);

String reason = intent.getStringExtra(ConnectivityManager.EXTRA_REASON);
boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);