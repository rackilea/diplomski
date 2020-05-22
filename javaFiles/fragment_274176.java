class MainPanel extends JPanel implements MouseMotionListener {

  public int mouseX, mouseY;
  // everything else

  public Point getMousePosition() {
      return new Point(this.mouseX, this.mouseY);
  } 
}