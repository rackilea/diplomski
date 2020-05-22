public void update(Graphics g, JComponent c) {
    AbstractButton button = (AbstractButton)c;
    if ((c.getBackground() instanceof UIResource) &&
              button.isContentAreaFilled() && c.isEnabled()) {
        ButtonModel model = button.getModel();
        if (!MetalUtils.isToolBarButton(c)) {
            if (!model.isArmed() && !model.isPressed() &&
                    MetalUtils.drawGradient(
                    c, g, "Button.gradient", 0, 0, c.getWidth(),
                    c.getHeight(), true)) {
                paint(g, c);
                return;
            }
        }
        else if (model.isRollover() && MetalUtils.drawGradient(
                    c, g, "Button.gradient", 0, 0, c.getWidth(),
                    c.getHeight(), true)) {
            paint(g, c);
            return;
        }
    }
    super.update(g, c);
}