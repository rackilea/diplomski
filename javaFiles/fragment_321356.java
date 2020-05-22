public class HighlightCaret extends DefaultCaret {

    @Override
    public void install(JTextComponent c) {
        super.install(c);
        setSelectionVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextComponent component = getComponent();
        if (component.isEnabled()) {
            if (component.isEditable()) {
                setVisible(true);
            }
            setSelectionVisible(true);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        setVisible(false);
    }
}