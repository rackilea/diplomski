class MyPanel extends JPanel {
        ...
        private boolean holdedInsideCircle = false;


           public MyPanel() {

               addMouseListener(new MouseAdapter() {
                   public void mousePressed(MouseEvent e) {
                    if ((X<=e.getX() && X+R>=e.getX()) && ( Y<=e.getY() && Y+R>=e.getY()))
                        moveVertex(e.getX(),e.getY());
                        holdedInsideCircle = true;
                   }
                   @Override
                   public void mouseReleased(MouseEvent e) {
                       //Doesn't matter where, if the mouse button is released
                       holdedInsideCircle = false;
                   }
               });


               addMouseMotionListener(new MouseAdapter() {
                   public void mouseDragged(MouseEvent e) {
                       //if ((X<=e.getX() && X+R>=e.getX()) && ( Y<=e.getY() && Y+R>=e.getY()))
                       if(holdedInsideCircle)
                           moveVertex(e.getX(),e.getY());
                   }
               });

        }