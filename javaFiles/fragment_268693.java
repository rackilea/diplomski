public class ShapeButtonUI extends BasicButtonUI {

    private Shape shape;

    public ShapeButtonUI(Shape shape) {
        this.shape = shape;
    }

    protected Color getSelectColor() {
        return UIManager.getColor(getPropertyPrefix() + "select");
    }

    protected Color getDisabledTextColor() {
        return UIManager.getColor(getPropertyPrefix()
                        + "disabledText");
    }

    protected Color getFocusColor() {
        return UIManager.getColor(getPropertyPrefix() + "focus");
    }

    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
    }

    @Override
    protected void uninstallDefaults(AbstractButton b) {
        super.uninstallDefaults(b);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setClip(shape);
        Rectangle bounds = shape.getBounds();
        LinearGradientPaint lgp = new LinearGradientPaint(
                        new Point(bounds.x, bounds.y),
                        new Point(bounds.x, bounds.y + bounds.height),
                        new float[]{0, 1},
                        new Color[]{c.getBackground().brighter(), c.getBackground().darker()});
        g2d.setPaint(lgp);
        g2d.fill(shape);
        g2d.dispose();
        g2d = (Graphics2D) g.create();
        g2d.setColor(c.getForeground());
        g2d.draw(shape);
        g2d.dispose();
        super.paint(g, c);
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        super.paintButtonPressed(g, b);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b,
                    Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        super.paintFocus(g, b, viewRect, textRect, iconRect);
    }

    @Override
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        super.paintText(g, b, textRect, text);

//          ButtonModel model = b.getModel();
//          FontMetrics fm = SwingUtilities2.getFontMetrics(c, g);
//          int mnemIndex = b.getDisplayedMnemonicIndex();
//
//          /* Draw the Text */
//          if (model.isEnabled()) {
//              /**
//               * * paint the text normally
//               */
//              g.setColor(b.getForeground());
//          } else {
//              /**
//               * * paint the text disabled **
//               */
//              g.setColor(getDisabledTextColor());
//          }
//          SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemIndex,
//                          textRect.x, textRect.y + fm.getAscent());

    }

    @Override
    public Dimension getMinimumSize(JComponent c) {
        Rectangle bounds = shape.getBounds();
        return new Dimension(bounds.x + bounds.width + 1, bounds.y + bounds.height + 1);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        Rectangle bounds = shape.getBounds();
        return new Dimension(bounds.x + bounds.width + 1, bounds.y + bounds.height + 1);
    }

    @Override
    public Dimension getMaximumSize(JComponent c) {
        Rectangle bounds = shape.getBounds();
        return new Dimension(bounds.x + bounds.width + 1, bounds.y + bounds.height + 1);
    }

}