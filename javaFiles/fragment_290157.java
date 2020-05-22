public class POJOBindingExample extends Application {

    private TextField nameTextField = new TextField();
    private TextField orderTextField = new TextField();
    private TextField weightTextField = new TextField();
    private TextField commentTextField = new TextField();
    private TaskAdapter adapter;

    @Override
    public void start(Stage primaryStage) {
        Task task = new Task();
        adapter = new TaskAdapter(task);

        // ... etc
    }
}