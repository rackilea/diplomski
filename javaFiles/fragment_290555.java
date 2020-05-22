public class MyJButtonMatcher extends NamedComponentMatcherTemplate<JButton> {

    private String text;
    private int index;

    public MyJButtonMatcher(String text, int index) {
        super(JButton.class);
        this.text = text;
        this.index = index;
        requireShowing(true);
    }

    @Override
    protected boolean isMatching(JButton button) {
        if (isNameMatching(button.getName()) && arePropertyValuesMatching(text, button.getText())) {
            return index-- == 0;
        } else {
            return false;
        }
    }
}