CloseableHttpClient httpClient = HttpClients.custom()
        .setConnectionManager(YourConnectionMgr.getInstance())
        .addInterceptorLast(new HttpRequestInterceptor() {
            public void process(
                    final HttpRequest request, 
                    final HttpContext context) throws HttpException, IOException { 

                    if (request.getRequestLine().getMethod() == "POST"){                                
                        request.addHeader("Content-Type", "application/json") ;