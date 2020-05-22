public class Application {
    public static void main(String[] args) throws Exception {
        new Circle().draw();
        ((Shape) Class.forName("Triangle").getConstructor().newInstance()).isDrawn();
        ((Shape) Class.forName("Square").getConstructor().newInstance()).erase();
    }
}