HttpHost myproxy = new HttpHost("myproxy", 8080)
CloseableHttpClient client = HttpClientBuilder.create()
        .setProxy(myproxy)
        .setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy() {

            @Override
            public boolean isAuthenticationRequested(HttpHost authhost, HttpResponse response, HttpContext context) {

                if (myproxy.equals(authhost)) {
                    context.setAttribute("proxy.status", response.getStatusLine());
                }
                return super.isAuthenticationRequested(authhost, response, context);
            }
        })
        .build();

HttpClientContext context = HttpClientContext.create();
HttpGet get = new HttpGet("https://httpbin.org/");
try (CloseableHttpResponse response = client.execute(get, context)) {
    EntityUtils.consume(response.getEntity());
}
StatusLine proxyStatus = context.getAttribute("proxy.status", StatusLine.class);
System.out.println("Proxy said " + proxyStatus);