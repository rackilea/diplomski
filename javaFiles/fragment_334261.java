Point p1;
Point p2;

View view = new View(this);

view.setOnTouchListener(new View.OnTouchListener() {
       public boolean onTouch(View v, MotionEvent event) {
         if(event.getAction() == MotionEvent.ACTION_DOWN)
            p1 = new Point((int) event.getX(), (int) event.getY());
         else if(event.getAction() == MotionEvent.ACTION_UP)
            p2 = new Point((int) event.getX(), (int) event.getY());

         return false;
      }
});