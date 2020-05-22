HttpParams httpParameters = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(httpParameters, 5000);
    DefaultHttpClient result = new DefaultHttpClient(httpParameters);


    MySocketFactory mySocketFactory = new MySocketFactory();
    Scheme scheme = new Scheme("https", mySocketFactory, port);

    result.getConnectionManager().getSchemeRegistry().register(scheme);