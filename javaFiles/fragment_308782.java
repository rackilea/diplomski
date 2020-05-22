public static String postPage1(list of parameters to be passed in the post form) throws HttpException {
    BasicNameValuePair[] data = {
        new BasicNameValuePair("field name", "param1"),
        ......
    };
    HttpPost post = new HttpPost(sURL);

    // post.setRequestBody(data);
    try {
        post.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));

        HttpResponse res;
        res = client.execute(post);
        int statusCode;

        BasicResponseHandler myHandler = new BasicResponseHandler();
        String content = myHandler.handleResponse(res);
        return content;
    } catch (...) {

    }
}