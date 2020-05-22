DefaultHttpClient httpclient = new DefaultHttpClient();
    try {

        httpclient.getCredentialsProvider().setCredentials(
            new AuthScope("localhost", 9009),
            new UsernamePasswordCredentials("username", "password*"));

        HttpGet httpget = new HttpGet("http://localhost:9009/path/list");

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        System.out.println("executing request" + httpget.getRequestLine());

        String responseBody = httpclient.execute(httpget, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
        System.out.println("----------------------------------------");
        System.out.println("Job Done!");
    } catch (Exception ex) {
        Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        httpclient.getConnectionManager().shutdown();
    }
}