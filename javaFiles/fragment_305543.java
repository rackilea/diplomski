public class Xylophone extends Activity implements onTouchLister{
    public static final String TAG = "Xylophone";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        /*Either have your parent view register THIS (Xylophone) as its listener, or have each button register THIS(Xylophone) as its listener.*/
        yourParentView.setOnTouchListener(this);
        //or
        img02.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(TAG, "ID:" + Integer.toString(v.getId()));
        Log.i(TAG, "Pointer count: " + event.getPointerCount());        
        Log.i(TAG, "Action: " + event.getActionMasked());
        Log.i(TAG, "Action index: " + event.getActionIndex());
    }