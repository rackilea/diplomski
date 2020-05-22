public class ButtonHandler implements EventHandler<ActionEvent> {
    private final String text;
    private final Label label;

    public ButtonHandler(int number, Label label) {
        this.text = "Button " + number + " clicked";
        this.label = label;
    }

    @Override
    public void handle(ActionEvent e) {
        System.out.println(text);
        label.setText(text);
    }
}