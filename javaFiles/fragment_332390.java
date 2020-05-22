...
private Ellipse2D ellipse = null; //also works w/o this assignment.
private Color c = Color.MAGENTA;    

public Help_Option(int x, int y){
    Help_Option.x = x;
    Help_Option.y = y;
    ellipse = new Ellipse2D.Double(0, 0, x, y);
    this.addMouseMotionListener(this);
}
...