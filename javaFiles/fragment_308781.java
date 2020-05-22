public static String getPage(String sURL) throws HttpException {
    HttpGet method = new HttpGet(sURL);

    // method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
    // new DefaultHttpMethodRetryHandler(3, false));

    try {
        /*
        * int statusCode = client.execute(method); if (statusCode !=
        * HttpStatus.SC_OK) { System.err.println("Method failed: " +
        * method.getStatusLine()); }
        */HttpResponse res;
        res = client.execute(method);

        BasicResponseHandler myHandler = new BasicResponseHandler();
        String content = myHandler.handleResponse(res);
        //extract dynamic parameters here
        return content;
    } catch(...) {

    }
}