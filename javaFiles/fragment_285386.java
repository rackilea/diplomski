public class TimerListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
           calcEndX( clublength, angle );
           calcEndY( clublength, angle );
      }
   }

   public void calcEndX( int clublength, int angle ){
       endX = startX + clublength * Math.sin(Math.toRadians(angle));
   }
   public void calcEndY( int clublength, int angle ){
       endY = startY + clublength * Math.cos(Math.toRadians(angle));
   }
    public double getEndX(){
       return endX;
   }
    public double getEndY(){
       return endY;
   }