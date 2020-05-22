class BorderUtil {

    @SuppressWarnings({ "unchecked", "serial" })
    public static <T extends JTextField> T createTextField(T field, String text, int x, int y, int width,
            int height) {

        T f = null;
        if (field instanceof JPasswordField) {
            f = (T) new JPasswordField(text) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(getBackground());
                    g.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                    super.paintComponent(g);
                }
            };
        } else {
            f = (T) new JTextField(text) {
                @Override
                protected void paintComponent(Graphics g) {
                    g.setColor(getBackground());
                    g.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                    super.paintComponent(g);
                }
            };
        }

        f.setBounds(x, y, width, height);
        f.setForeground(Color.GRAY);
        f.setHorizontalAlignment(JTextField.CENTER);
        f.setOpaque(false);
        f.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        return f;
    }
}