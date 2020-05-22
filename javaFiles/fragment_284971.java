if(AppSettings.isNetworkAvailable(context, showDialog)) {
    HttpResponse httpResponse = null;
    AsyncHttpGet asyncHttpGet = new AsyncHttpGet(mHttpClient, mHttpContext);

    String url = BASE_URI + atPath;
    asyncHttpGet.execute(url);

    try {
        httpResponse = asyncHttpGet.get();
        System.out.println("Response: " + httpResponse);
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }

    if(isAccepted(httpResponse)) {
        return httpResponse;
    } else {
        return null;
    }
}