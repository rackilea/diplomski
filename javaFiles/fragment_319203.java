// Setup.
HTTP2Client http2Client = new HTTP2Client();
SslContextFactory sslContextFactory = new SslContextFactory();
HttpClient httpClient = new HttpClient(new HttpClientTransportOverHTTP2(http2Client), sslContextFactory);
httpClient.start();

// Does webtide.com support HTTP/2 ?
ContentResponse response = httpClient.GET("https://webtide.com/");
// No errors, yes it supports HTTP/2 !