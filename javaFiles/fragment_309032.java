// Setup and start the HTTP2Client.
    HTTP2Client client = new HTTP2Client();
    SslContextFactory sslContextFactory = new SslContextFactory();
    client.addBean(sslContextFactory);
    client.start();

    // Connect to the remote host to obtains a Session.
    FuturePromise<Session> sessionPromise = new FuturePromise<>();
    client.connect(sslContextFactory, new InetSocketAddress(host, port), new ServerSessionListener.Adapter(), sessionPromise);
    Session session = sessionPromise.get(5, TimeUnit.SECONDS);

    // Use the session to make requests.
    HttpFields requestFields = new HttpFields();
    requestFields.put("User-Agent", client.getClass().getName() + "/" + Jetty.VERSION);
    MetaData.Request metaData = new MetaData.Request("GET", new HttpURI("https://webtide.com/"), HttpVersion.HTTP_2, requestFields);
    HeadersFrame headersFrame = new HeadersFrame(metaData, null, true);
    session.newStream(headersFrame, new Promise.Adapter<>(), new Stream.Listener.Adapter()
    {
        @Override
        public void onHeaders(Stream stream, HeadersFrame frame)
        {
            // Response headers.
            System.err.println(frame);
        }

        @Override
        public void onData(Stream stream, DataFrame frame, Callback callback)
        {
            // Response content.
            System.err.println(frame);
            callback.succeeded();
        }
    });