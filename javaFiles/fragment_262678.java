@Override
public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    Object msg = e.getMessage();
    if (msg instanceof HttpRequest) {
        handleHttpRequest(ctx, (HttpRequest) msg);
    } else if (msg instanceof WebSocketFrame) {
        handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    }
}

private void handleHttpRequest(ChannelHandlerContext ctx, HttpRequest req) throws Exception {
    // Allow only GET methods.
    if (req.getMethod() != GET) {
        sendHttpResponse(ctx, req, new DefaultHttpResponse(HTTP_1_1, FORBIDDEN));
        return;
    }

    // Send the demo page and favicon.ico
    if (req.getUri().equals("/")) {
        HttpResponse res = new DefaultHttpResponse(HTTP_1_1, OK);

        ChannelBuffer content = WebSocketServerIndexPage.getContent(getWebSocketLocation(req));

        res.setHeader(CONTENT_TYPE, "text/html; charset=UTF-8");
        setContentLength(res, content.readableBytes());

        res.setContent(content);
        sendHttpResponse(ctx, req, res);
        return;
    } else if (req.getUri().equals("/favicon.ico")) {
        HttpResponse res = new DefaultHttpResponse(HTTP_1_1, NOT_FOUND);
        sendHttpResponse(ctx, req, res);
        return;
    }

    // Handshake
    WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
            this.getWebSocketLocation(req), null, false);
    this.handshaker = wsFactory.newHandshaker(req);
    if (this.handshaker == null) {
        wsFactory.sendUnsupportedWebSocketVersionResponse(ctx.getChannel());
    } else {
        this.handshaker.handshake(ctx.getChannel(), req);
    }
}