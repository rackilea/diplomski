private boolean isConnectionReady(Channel ch) {
        try {
            WebSocketClientHandler handler = (WebSocketClientHandler) ch.pipeline().get("handler");
            return handler.handshakeFuture().sync().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }