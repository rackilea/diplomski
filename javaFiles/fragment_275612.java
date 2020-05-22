public class Launcher {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        Application app = new Application();
        app.start(data);
        Scanner scanner = new Scanner(System.in);
        System.out.println("the current data is: " + data); // "render"
        String line;
        while (!"exit".equals(line = scanner.nextLine())) { // loop is done by the framework
            app.handleInput(line); // handle input event
            System.out.println("the current data is: " + data); // "render"
        }
    }
}