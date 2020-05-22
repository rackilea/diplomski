public class httpServerWrapper{
        private HashMap map = ...;

        public httpServerWrapper(int port) {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/hashmap", new Handler());
            server.start();
        }

        public static void main(String args[]){
            int port = 8000;
            new httpServerWrapper(port);
        }

        public class Handler implements HttpHandler {
            public void handle(HttpExchange xchg) throws IOException {

                map.get(...);
            }
        }
    }