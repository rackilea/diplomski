class HelloComponent2 extends JComponent
    implements MouseMotionListener
{
  String theMessage;
  int messageX = 125;
  int messageY = 95;

  public HelloComponent2( String message ) {
    theMessage = message;
    addMouseMotionListener(this);
  }

  public void paintComponent(MouseEvent e) {
    // Save the mouse coordinates and paint the message.
    messageX = e.getX();

    messageY = e.getY();
    repaint();
  }
  //Here it is the method you forgot include in your class
  @Override
  public void mouseDragged(MouseEvent e) {

  }

  public void mouseMoved(MouseEvent e) {

  }
}