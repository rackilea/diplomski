public class DrawView extends View {

     // here you define hashmap for user touch points

      Paint paint = new Paint();

  public DrawView(Context context) {
      super(context);            
  }

  @Override
  public void onDraw(Canvas canvas) {
      yourRandomFunction(-99,-99);


  }

  public void yourRandomFunction(float x , float y ){
     //for first time user touch 
     // if -99 && -99 { 
    //Calculate random points here.

    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(3);
    canvas.drawRect(30, 30, 80, 80, paint);
    paint.setStrokeWidth(0);
    paint.setColor(Color.CYAN);
    canvas.drawRect(33, 60, 77, 77, paint );
    paint.setColor(Color.YELLOW);
    canvas.drawRect(33, 33, 77, 60, paint );
    // add points to hashmap
}
//else check in hashmap if exist then {
  //Calculate random points here.
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(3);
    canvas.drawRect(30, 30, 80, 80, paint);
    paint.setStrokeWidth(0);
    paint.setColor(Color.CYAN);
    canvas.drawRect(33, 60, 77, 77, paint );
    paint.setColor(Color.YELLOW);
    canvas.drawRect(33, 33, 77, 60, paint );
    // add point to hashmap
 } 

}

@Override
public boolean onTouchEvent(MotionEvent event) {
      float eventX = event.getX();
       float eventY = event.getY();

    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
      //check points in hashmap 

      return true;
    case MotionEvent.ACTION_MOVE:

      break;
    case MotionEvent.ACTION_UP:
      // nothing to do
      yourRandomFuncntion(eventX,eventY);
      break;
    default:
      return false;
    }

    // Schedules a repaint.
    invalidate();
    return true;
      }
    }