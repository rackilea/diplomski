public class MyTextField extents JTextField implements FocusListener {

    private boolean hasFocus = false;

    public void addNotify() {
        super.addNotify();
        addFocusListener(this);
    }

    public void removeNotify() {
        removeFocusListener(this);
        super.removeNotify();
    }

    public void focusGained(FocusEvent evt) {

        hasFocus = true;

    }

    public void focusLost(FocusEvent evt) {

        hasFocus = false;

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String label = getLabel();
        if (!hasFocus && label != null && (getText() == null || getText().length() == 0)) {
            // As above...
        }
    }
}