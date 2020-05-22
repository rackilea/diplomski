public class MyTextbox extends HtmlMacroComponent {

    @Wire("#mcTextbox")
    private Textbox textbox;

    @Wire("#mcLabel")
    private Label label;

    private String caption;

    private boolean mandatory;

    public MyTextbox() {
        compose(); // this wires the whole thing
    }

    public void setMandatory(final boolean value) {
        mandatory = value;
        updateCaption();
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setCaption(final String value) {
        caption = value;
        updateCaption();
    }

    public String getCaption() {
        return caption;
    }

    protected void updateCaption() {
        label.setValue(mandatory ? caption + "*" : caption);
    }

    public String getValue() {
        return textbox.getValue();
    }

    public void setValue(final String value) {
        textbox.setValue(value);
    }

}