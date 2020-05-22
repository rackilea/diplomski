public class ToolTippedJLabelOrWhateverYouWantToCallIt extends JLabel {
    String tooltip = null;
    @Override
    public void setToolTipText(String text) {
        tooltip = text;
        super.setToolTipText(text);
    }
    @Override
    public String getToolTipText() {
        return tooltip;
    }
}