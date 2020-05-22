//runnable inside the httpclient's implementation of 'exec'
    public void run() {
        int httprc = 999;
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(YourConnectionMgr.getInstance())
                .addInterceptorLast(new HttpRequestInterceptor() {
                    public void process(
                            final HttpRequest request, 
                            final HttpContext context) throws HttpException, IOException { 

                            if(request.getRequestLine().getMethod() == "GET"){                                                                                                  
                                    request.addHeader("X-Parse-Application-Id", ParseApplication.key_appId);
                                    request.addHeader("X-Parse-REST-API-Key", ParseApplication.key_rest);
                                    request.addHeader("X-Parse-Session-Token",prefs.getString("default_parse_user_token", ""));
                                }

                    }
                })
                .build();   

        try {                       
            HttpResponse response = null;
            switch (method) {
            case GET:
                HttpGet httpGet = new HttpGet(url);
                httpGet.setProtocolVersion(new ProtocolVersion("HTTP", 1,1));
                httpGet.setConfig(this.config);
                response = httpClient.execute(httpGet, context);
                break; }


        } catch (Exception e) {
            handler.sendMessage(Message.obtain(handler,
                    HttpConnection.DID_ERROR, e));
        }