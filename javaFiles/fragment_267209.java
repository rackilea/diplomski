WebSocket websocket = new WebSocketFactory()
    .createSocket("ws://...")
    .addListener(new WebSocketAdapter() {
        @Override
        public void onFrame(WebSocket ws, WebSocketFrame frame) {
            // If the frame is a text frame with FIN bit cleared, or
            // if the frame is a continuation frame.
            if ((frame.isTextFrame() && frame.getFin() == false) ||
                frame.isContinuationFrame()) {
                // The payload of the frame. There is no guarantee
                // that this byte array is a valid UTF-8 sequence.
                byte[] payload = frame.getPayload();

                // Check whether the payload is a valid UTF-8 sequence
                // if you want to.
                checkPayload(payload);
            }
        }
    })
    .connect();