final DefaultHttpClient client = new DefaultHttpClient();
HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
HttpHost target = new HttpHost("www.google.com", 443, "https");
client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
HttpProtocolParams
        .setUserAgent(client.getParams(),
                "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
final HttpGet get = new HttpGet("/");

HttpResponse response = client.execute(target, get);