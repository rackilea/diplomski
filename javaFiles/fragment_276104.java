public class myPanel extends Composite {

    private HTMLPanel panel = new HTMLPanel();

    public myPanel(String id, int anotherParameter) {
        // set HTML to panel based on your parameters
        initWidget(panel);
    }
}