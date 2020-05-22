@Override
public void init() {
    get(new Route("/test") {
        @Override
        public Object handle(Request request, Response response) {
            return "response goes here;
        }

    });