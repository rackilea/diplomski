@WebService
public class HelloWebService {
    public String sayHello(String name) {
        return "Hi" + name;
    }

    public static void main(String ... args) {
        HelloWebService hello = new HelloWebService();
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/hello", hello);
    }
}