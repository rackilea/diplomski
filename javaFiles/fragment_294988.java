class CustomTextField extends JTextField {
  private Color inactiveColor = UIManager.getColor("TextField.inactiveBackground");

  public void setDisabledBackgroundColor(Color inactiveColor) {
    this.inactiveColor = inactiveColor;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (!isEditable() || !isEnabled()) {
      setOpaque(false);
      g.setColor(inactiveColor);
      g.fillRect(0, 0, getWidth(), getHeight());
    } else {
      setOpaque(true);
    }
    super.paintComponent(g);
  }
}