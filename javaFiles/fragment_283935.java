CloseableHttpClient client = HttpClientBuilder.create()
        .addInterceptorFirst(new HttpRequestInterceptor() {
            @Override
            public void process(
                    final HttpRequest request,
                    final HttpContext context) throws HttpException, IOException {
                boolean b = (Boolean) context.getAttribute("my-config");
                if (b) {
                    // do something useful
                }

            }
        })
        .build();
HttpClientContext context = HttpClientContext.create();
context.setAttribute("my-config", Boolean.TRUE);
CloseableHttpResponse response1 = client.execute(new HttpGet("/"), context);
response1.close();
context.setAttribute("my-config", Boolean.FALSE);
CloseableHttpResponse response2 = client.execute(new HttpGet("/"), context);
response2.close();