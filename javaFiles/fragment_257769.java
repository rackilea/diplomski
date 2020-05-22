public class SimpleServer {
    public static void main(String[] args) {
        get("/json", (req, res) -> {
            res.type("application/json");
            return new JsonMaker().getJson( ... );
        });
    }
}