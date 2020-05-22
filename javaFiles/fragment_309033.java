// Setup and start HttpClient with HTTP/2 transport.
    HTTP2Client http2Client = new HTTP2Client();
    SslContextFactory sslContextFactory = new SslContextFactory();
    HttpClient httpClient = new HttpClient(new HttpClientTransportOverHTTP2(http2Client), sslContextFactory);
    httpClient.start();

    // Make a request.
    ContentResponse response = httpClient.GET("https://webtide.com/");