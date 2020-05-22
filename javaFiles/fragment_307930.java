public class Main {
    public static void main(String[] args) {
        get("/hello", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                response.type("");
                response.body("hello world");
                return response;
            }
        });
    }
}