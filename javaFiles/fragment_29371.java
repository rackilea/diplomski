addMouseListener(new MouseAdapter() {
 private int delay = 1000;//1 second
 private Timer timer = null;
 private int startTime =0;

  @Override
  public void mouseMoved(MouseEvent e) {
    Point p= e.getLocationOnScreen();
    boolean pointInArea=false;
    //check if Point p is within the boundaries of a rectangle.          
    if(pointInArea){
        //A JFrame is queued to be shown
        if(System.currentTimeMillis()-startTime>delay){
          //A JFrame has been already shown, then show a new one
          startTime = System.currentTimeMillis();
          timer = new Timer();                    
          timer.schedule(new TimerTask(){
              @Override
              public void run() {
                //LAUNCH JFrame
              }

          }, delay);                     
        }
     }
     else (!pointInArea && timer != null){
        timer.cancel();
        timer = null;                        
     }
  }                
});