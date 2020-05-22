public class Main {

    public static void main(String[] args) {
        Weld weld = new Weld();

        WeldContainer container = weld.initialize();

        container.select(ApiRequest.class).get().rest();

        container.shutdown();
    }
}