public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/game.jnlp", new FileHandler("game.jnlp"));
        server.createContext("/game.jar", new FileHandler("game.jar"));
        server.setExecutor(null); 
        server.start();
    }

    static class FileHandler implements HttpHandler {
        String file = "";
        public FileHandler(String string) {
            file = string;
        }
        @Override
        public void handle(HttpExchange t) throws IOException {
            byte[] data = IOUtils.toByteArray(getClass().getResourceAsStream(file));
            t.sendResponseHeaders(200, data.length);
            OutputStream os = t.getResponseBody();
            os.write(data);
            os.close();
        }
    }