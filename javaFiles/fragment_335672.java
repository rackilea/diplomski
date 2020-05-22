public class View extends Application {

    private int value;

    public void start(Stage stage) {
        List<String> unnamedParams = getParameters().getUnnamed();
        if (unnamedParams.size() > 0) {
            this.value = Integer.parseInt(unnamedParams.get(0));
        } else {
            throw new IllegalStateException("No argument has been provided");
        }
    }