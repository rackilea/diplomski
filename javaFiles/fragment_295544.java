public class MyButtonUI extends BasicButtonUI {

    public static final int BUTTON_HEIGHT = 24;

    private static final MyButtonUI INSTANCE = new MyButtonUI ();

    public static ComponentUI createUI(JComponent b) {
        return INSTANCE;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        Graphics2D g2d = (Graphics2D) g;
        final int buttonWidth = button.getWidth();
        if (button.getModel().isRollover()) {
            // Rollover
            GradientPaint gp = new GradientPaint(0, 0, Color.green, 0, BUTTON_HEIGHT * 0.6f, Color.red, true);
            g2d.setPaint(gp);
        } else if (button.isEnabled()) {
            // Enabled
            GradientPaint gp = new GradientPaint(0, 0, Color.red, 0, BUTTON_HEIGHT * 0.6f, Color.gray, true);
            g2d.setPaint(gp);
        } else {
            // Disabled
            GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, BUTTON_HEIGHT * 0.6f, Color.blue, true);
            g2d.setPaint(gp);
        }
        g2d.fillRect(0, 0, buttonWidth, BUTTON_HEIGHT);
        super.paint(g, button);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        if (isInToolBar(button)) {
            // Toolbar button
            button.setOpaque(false);
            super.paint(g, button);
        } else if (button.isOpaque()) {
            // Other opaque button
            button.setRolloverEnabled(true);
            button.setForeground(Color.white);
            paint(g, button);
        } else {
            // Other non-opaque button
            super.paint(g, button);
        }
    }

    private boolean isInToolBar(AbstractButton button) {
        return SwingUtilities.getAncestorOfClass(JToolBar.class, button) != null;
    }
}