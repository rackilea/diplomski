gestureDetector.setOnDoubleTapListener(new OnDoubleTapListener() {

     @Override 
     public boolean onSingleTapConfirmed(MotionEvent e) {
         return false; 
     } 

     @Override 
     public boolean onDoubleTap(MotionEvent e) {
         mapView.getController().zoomInFixing((int) e.getX(), (int) e.getY());
         return false; 
     }
     //you could override more methods here if you want 
}