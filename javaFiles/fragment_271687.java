class Coordinate {  // there are some class in Java that already does that, 
                    //leave it to you to find out  :)
  int x;
  int y;
}

List<Coordinate> theOnlyLine=....;
public void mouseDragged(MouseEvent m) {
    theOnlyLine.add(new Coordinate(m.getX(), m.getY());
}

public void mouseReleased(MouseEvent e) {
    theOnlyLine.add(new Coordinate(m.getX(), m.getY());
}

public void paint(Graphics g) {

  int prevX = -1;
  int prevY = -1;
  for (Coordinate coordinate : theOnlyLine) {
    if (prevX > 0 && prevY > 0) {
      g.drawLine(prevX, prevY, coordinate.getX(), coordinate.getY());
    }
    prevX = coordinate.getX();
    prevY = coordinate.getY();
  }
}