DefaultHttpClient httpclient = new DefaultHttpClient();

ProxySelectorRoutePlanner routePlanner = new ProxySelectorRoutePlanner(
     httpclient.getConnectionManager().getSchemeRegistry(),
     ProxySelector.getDefault());

httpclient.setRoutePlanner(routePlanner);