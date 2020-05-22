try {
        HttpServer hs = HttpServer.create(new InetSocketAddress(8888), 0);
        hs.createContext("/test", new HttpHandler() {
                public void handle(HttpExchange t) throws IOException {
                InputStream is = t.getRequestBody();
                System.out.println(t.getRemoteAddress().toString());
                String response = "HelloWorld!!";
                t.sendResponseHeaders(200, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        hs.setExecutor(null);
        hs.start();
    } catch (IOException e) {
        e.printStackTrace();
   }