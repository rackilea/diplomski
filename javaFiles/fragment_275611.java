public class Application {

    private List<String> data;

    public void start(List<String> data) {
        // set up initial data
        data.add("Hello World");
        data.add("42");
        this.data = data;
    }

    public void handleInput(String input) {
        // react to user input
        data.clear();
        data.add("Your input was: " + input);
    }

}