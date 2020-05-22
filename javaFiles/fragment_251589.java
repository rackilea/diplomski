public void setText(JComponent c,
                    String text) {

    Objects.requireNonNull(c, "Component cannot be null");

    if (c instanceof JTextComponent) {
        ((JTextComponent) c).setText(text);
    } else if (c instanceof JLabel) {
        ((JLabel) c).setText(text);
    } else {
        throw new IllegalArgumentException(
            "Cannot set text of a " + c.getClass().getName());
    }
}