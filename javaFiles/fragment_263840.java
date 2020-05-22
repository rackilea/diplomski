static void updateBorder(JTextField textField,
                         Icon icon) {

    Border iconBorder = new AbstractBorder() {
        private static final long serialVersionUID = 1;

        @Override
        public Insets getBorderInsets(Component c,
                                      Insets insets)
        {
            insets.left = icon.getIconWidth() + 4;
            insets.right = insets.top = insets.bottom = 0;
            return insets;
        }

        @Override
        public void paintBorder(Component c,
                                Graphics g,
                                int x,
                                int y,
                                int width,
                                int height)
        {
            icon.paintIcon(c, g,
                x, y + (height - icon.getIconHeight()) / 2);
        }
    };

    Border oldBorder = textField.getBorder();

    // Inside text field's original border, place icon border
    // with a little empty space around it.
    textField.setBorder(BorderFactory.createCompoundBorder(
        oldBorder,
        BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(2, 2, 2, 2),
            iconBorder)));
}