SslContextFactory sslContextFactory = new SslContextFactory(true);

    HTTP2Client http2Client = new HTTP2Client();
    HttpClient httpClient = new HttpClient(new HttpClientTransportOverHTTP2(http2Client), sslContextFactory);
    httpClient.start();

    ContentResponse response = httpClient.GET("https://ec2-52-57-54-142.eu-central-1.compute.amazonaws.com/");