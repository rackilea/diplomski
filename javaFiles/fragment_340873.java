interface Renderer {
  void draw( Graphics2D g, Point start, Point end );
}

class OvalRenderer implements Renderer {
  public void draw( Graphics2D g, Point start, Point end ) {
    g.drawOval(start.getX(), start.getY(), end.getY(), end.getY() );
  }
}

class CanvasListener extends MouseAdapter {
  Point start;
  public void mousePressed(MouseEvent e){
    start = e.getPoint(); 
  }

  public void mouseDragged(MouseEvent e){  
    //currentRenderer is defined elsewhere and just made accessible to the listener
    currentRenderer.draw( component.getGraphics(), start, e.getPoint() );
  }

  public void mouseReleased(MouseEvent e){  
    currentRenderer.draw( image.getGraphics(), start, e.getPoint() );
  }
}