slider.setUI(new BasicSliderUI(slider) {
  public void paintThumb(Graphics g) {
    super.paintThumb(g);
    g.setColor(Color.black);
    g.drawString(Integer.toString(slider.getValue()), thumbRect.x, thumbRect.y + thumbRect.height);
  }
});