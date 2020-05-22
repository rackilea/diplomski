public class LabelUI extends MetalLabelUI {
    private static final int SWING_ELLIPSES_LEN = "...".length();
    private static final ComponentUI LABEL_UI_INSTANCE = new LabelUI();
    private String displayedText;
    public static ComponentUI createUI(JComponent c) {
        return LABEL_UI_INSTANCE;
    }
    public String getText() {
        return displayedText;
    }
    protected String layoutCL(JLabel label, FontMetrics fontMetrics, String text, Icon icon, Rectangle viewR, Rectangle iconR, Rectangle textR) {
        displayedText = super.layoutCL(label, fontMetrics, text, icon, viewR, iconR, textR);
        String truncationString = (String)label.getClientProperty("LabelUI.truncationString");
        if (truncationString != null && !displayedText.equals(text)) {
            displayedText = displayedText.subSequence(0, displayedText.length() - SWING_ELLIPSES_LEN) + truncationString;
        }
        return displayedText;
    }
}