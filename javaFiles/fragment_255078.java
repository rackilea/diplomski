// Create protocol processor
HttpProcessor processor = HttpProcessorBuilder.create()
        .addAll(new RequestContent(),
                new RequestTargetHost(),
                new RequestConnControl(),
                new RequestUserAgent("HTTP/1.1"))
        .build();

// Target host
InetSocketAddress target = new InetSocketAddress("localhost", 8080);

// Create custom connection that exposes its session input buffer
CustomHttpConnection conn = new CustomHttpConnection(10 * 1024);
try {

    // Open socket
    Socket socket = new Socket();
    socket.connect(target, 5000);
    // Bind it to the connection
    conn.bind(socket);

    // Create and initialize request
    HttpGet request = new HttpGet("/");
    // Force connection close
    request.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);

    // Create and initialize execution context
    HttpClientContext context = HttpClientContext.create();
    context.setTargetHost(new HttpHost(target.getHostName(), target.getPort()));
    context.setRequestConfig(RequestConfig.DEFAULT);
    context.setAttribute(HttpClientContext.HTTP_REQUEST, request);
    context.setAttribute(HttpClientContext.HTTP_CONNECTION, conn);

    // Process request
    processor.process(request, context);

    // Send request
    conn.sendRequestHeader(request);
    if (request instanceof HttpEntityEnclosingRequest) {
        conn.sendRequestEntity(((HttpEntityEnclosingRequest) request));
    }
    conn.flush();

    SessionInputBuffer connSessionInputBuffer = conn.getSessionInputBuffer();
    IdentityInputStream instream = new IdentityInputStream(connSessionInputBuffer);
    int l;
    byte[] buff = new byte[1024];
    while ((l = instream.read(buff)) != -1) {
        System.out.println(new String(buff, 0, l, Consts.ASCII));
    }
} finally {
    conn.close();
}