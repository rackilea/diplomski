@StyleSheet("MyStyleSheet.css")
public class ResponsiveLayout extends CssLayout {

    private static final long serialVersionUID = -1028520275448675976L;
    private static final String RESPONSIVE_LAYOUT = "responsive-layout";
    private static final String LABEL_ONE = "label-one";
    private static final String LABEL_TWO = "label-two";

    private Label labelOne = new Label();
    private Label labelTwo = new Label();

    public ResponsiveLayout() {
        config();
        addComponents(labelOne, labelTwo);
    }

    private void config() {
        addStyleName(RESPONSIVE_LAYOUT);
        labelOne.addStyleName(LABEL_ONE);
        labelTwo.addStyleName(LABEL_TWO);
    }
}