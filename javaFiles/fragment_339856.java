// Nothing interesting here, added for consistency.
public class Controller {
    private final Model model;

    public Controller(Model model) {
        // The frame is shown automatically in the model here.
        this.model = model;

        // The frame's setVisible is a control issue, should be called
        // from in here, not automatically in the model.
    }
}