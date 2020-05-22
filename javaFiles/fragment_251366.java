import static spark.Spark.*;

public class MyApp {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "{\"status\":\"OK\"}");

        get("*", (request, response) -> {
            System.out.println("404 not found!!");
            // email me the request details ...    
        );
    }
}