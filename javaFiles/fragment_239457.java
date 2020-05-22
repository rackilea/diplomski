// Just an example: does not deal with concurrency problems
private static final Set<WebSocket.Out<String>> SOCKETS = new HashSet<>();

public static WebSocket<String> heartUpdate() {
    return new WebSocket<String>() {
        public void onReady(final WebSocket.In<String> in,
                    final WebSocket.Out<String> out) {
            SOCKETS.add(out);
            in.onMessage(new Callback<String>() {
                @Override
                public void invoke(String event) throws Throwable {
                    for(WebSocket.Out<String> s: SOCKETS) {
                        s.write("SOME MESSAGE");    
                    }
                }
            });
            in.onClose(new Callback0() {
                @Override
                public void invoke() throws Throwable {
                    SOCKETS.remove(out);
                }
            });
        }
    };
}