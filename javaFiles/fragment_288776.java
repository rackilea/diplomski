public class MainActivity extends AppCompatActivity {
    public ConstraintLayout constraintLayout;
    LayoutInflater inflater ;
    public View rectimage3 ;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout0);
    inflater = getLayoutInflater();
    rectimage3 = inflater.inflate(R.layout.my_rectview, constraintLayout, false);
    final ImageView rectimage = (ImageView) findViewById(R.id.rectimage);

    //set Listeners
    rectimage.setOnTouchListener(new MySecOnTouchListener());
    rectimage3.setOnTouchListener(new MyOnTouchListener());
    constraintLayout.setOnDragListener(new MyDragListener());
}

//OnTouchListener of the first Rect
private final class MySecOnTouchListener implements View.OnTouchListener {
    public boolean onTouch(View sview, MotionEvent motionEvent){
        int action = motionEvent.getAction();
        if(action == MotionEvent.ACTION_DOWN);
            rectimage3.setVisibility(View.VISIBLE);
            constraintLayout.addView(rectimage3);

            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(rectimage3);
            rectimage3.startDrag(data, shadowBuilder, rectimage3, 0);
            rectimage3.setVisibility(View.INVISIBLE);
            return true;
        } else{
            return false;
        }
    }
}

//OnTouchListener of the movable Rects
private final class MyOnTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent){
        int action = motionEvent.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }
}

//OnDragListener of the Layout
class MyDragListener implements View.OnDragListener{
    @Override
    public boolean onDrag(View v, DragEvent event) {
        View view = (View) event.getLocalState();

        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_LOCATION:
                view.setX(event.getX()-(view.getWidth()/2));
                view.setY(event.getY()-(view.getHeight()/2));
                break;
            case DragEvent.ACTION_DROP:
                break;
        }
        return true;
    }
}