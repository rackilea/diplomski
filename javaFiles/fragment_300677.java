static public class ButtonUI extends MetalButtonUI {
    public static ComponentUI createUI(JComponent c) {
        return new ButtonUI();
    }

    @Override public void paint(Graphics g, JComponent c) {
        JSimpleLabel.activateAntiAliasing(g);

        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();

        String text = b.getText();
        clearTextShiftOffset();

        // perform UI specific press action, e.g. Windows L&F shifts text
        if (model.isArmed() && model.isPressed()) {
            paintButtonPressed(g,b); 
        }

        FontMetrics metrics = g.getFontMetrics();
        Rectangle2D stringBounds = metrics.getStringBounds(text, g);
        g.drawString(text,
                (b.getWidth() - (int)stringBounds.getWidth()) / 2,
                metrics.getLeading() + metrics.getMaxAscent() + (b.getHeight() - (int)stringBounds.getHeight()) / 2);

        if (b.isFocusPainted() && b.hasFocus()) {
            Rectangle viewRect = new Rectangle();
            final int inset = 1;
            viewRect.x = inset;
            viewRect.y = inset;
            viewRect.width = b.getWidth() - (inset + viewRect.x) - 1;
            viewRect.height = b.getHeight() - (inset + viewRect.y) - 1;
            g.setColor(getFocusColor());
            g.drawRect(viewRect.x, viewRect.y, viewRect.width, viewRect.height);
        }
    }       
}

public void init() {
    try {
        UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel() {
            private static final long serialVersionUID = 1L;
            @Override public UIDefaults getDefaults() {
                UIDefaults table = super.getDefaults();
                table.put("ButtonUI", ButtonUI.class.getName());
                return table;
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    // ...
}