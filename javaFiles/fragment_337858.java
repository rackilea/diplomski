public class MyController {
    private final Model model ;

    // usual @FXML-annotated fields, etc

    public MyController(Model model) {
        this.model = model ;
    }

    public void initialize() { ... }

    // handler methods, etc...
}