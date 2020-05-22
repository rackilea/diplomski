public class MyGestureDetector extends SimpleOnGestureListener {
public Context context;
public String phno;

public MyGestureDetector(Context con)
{
    this.context=con;       
}
@Override
public boolean onDown(MotionEvent e) {
    return super.onDown(e);
}
public MyGestureDetector(Context con) {
    this.context=con;
}
@Override
public boolean onDoubleTap(MotionEvent e) {
    System.out.println("in Double tap");

    return true;
}
@Override
public boolean onSingleTapUp(MotionEvent e) {
    System.out.println("in single tap up");
            //put your second activity.
    return super.onSingleTapUp(e);
}   
}