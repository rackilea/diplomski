CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet("your rest service api");
    CloseableHttpResponse response = httpclient.execute(httpget);
    try {
        HttpEntity entity = response.getEntity();

        if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
            String responseValue = EntityUtils.toString(entity);
            System.out.println(responseValue);
        } else {
            // log error
        }
    } finally {
        response.close();
    }
}