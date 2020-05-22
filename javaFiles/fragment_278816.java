try {
        HttpGet httpget = new HttpGet("http://httpbin.org/");
        HttpGet httpget1 = new HttpGet("http://httpbin.org/");

        System.out.println("Executing request " + httpget.getRequestLine());

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    if(entity != null){
                       httpclient.execute(httpget1, responseHandler1);
                    }else{
                       return "No response";
                    }
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }

        };

        ResponseHandler<String> responseHandler1 = new ResponseHandler<String>() {

            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }

        };
        String responseBody = httpclient.execute(httpget, responseHandler);
        System.out.println("----------------------------------------");
        System.out.println(responseBody);
    } finally {
        httpclient.close();
    }