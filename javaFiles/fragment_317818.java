public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,button,dragged;
LinearLayout layout;
int move=0,moveleft=30;
TextView m,ml;

public void play(View view){
    layout.setVisibility(View.VISIBLE);
    button.setVisibility(View.INVISIBLE);


    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Random randomGenerator = new Random();
    while (numbers.size() < 8) {

        int random = randomGenerator .nextInt(8)+1;
        if (!numbers.contains(random)) {
            numbers.add(random);
        }
    }
    b1.setText(Integer.toString(numbers.get(0)));
    b2.setText(Integer.toString(numbers.get(1)));
    b3.setText(Integer.toString(numbers.get(2)));
    b4.setText(Integer.toString(numbers.get(3)));
    b5.setText(Integer.toString(numbers.get(4)));
    b6.setText(Integer.toString(numbers.get(5)));
    b7.setText(Integer.toString(numbers.get(6)));
    b8.setText(Integer.toString(numbers.get(7)));
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    layout = (LinearLayout) findViewById(R.id.li);

    b1 = (Button) findViewById(R.id.b1);
    b2 = (Button) findViewById(R.id.b2);
    b3 = (Button) findViewById(R.id.b3);
    b4 = (Button) findViewById(R.id.b4);
    b5 = (Button) findViewById(R.id.b5);
    b6 = (Button) findViewById(R.id.b6);
    b7 = (Button) findViewById(R.id.b7);
    b8 = (Button) findViewById(R.id.b8);
    b9 = (Button) findViewById(R.id.b9);
    button = (Button) findViewById(R.id.button);
    m = (TextView) findViewById(R.id.move);
    ml = (TextView) findViewById(R.id.mleft);


    b1.setOnTouchListener(longClickListener);
    b2.setOnTouchListener(longClickListener);
    b3.setOnTouchListener(longClickListener);
    b4.setOnTouchListener(longClickListener);
    b5.setOnTouchListener(longClickListener);
    b6.setOnTouchListener(longClickListener);
    b7.setOnTouchListener(longClickListener);
    b8.setOnTouchListener(longClickListener);
    b9.setOnTouchListener(longClickListener);



}

OnTouchListener longClickListener =new OnTouchListener() {
    @Override
    public boolean onTouch(final View view, MotionEvent motionEvent) {

            DragShadow dragShadow = new DragShadow(view);

            ClipData clipData = ClipData.newPlainText("", "");
            view.startDrag(clipData, dragShadow, view, 0);

            Log.i("info", view.getTag().toString());
            Log.i("info", b1.getTag().toString());

            if (view.getTag().toString().matches(b1.getTag().toString())) {
                b2.setOnDragListener(dragListener);
                b4.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b3.setOnDragListener(null);
                b5.setOnDragListener(null);
                b6.setOnDragListener(null);
                b7.setOnDragListener(null);
                b8.setOnDragListener(null);
                b9.setOnDragListener(null);

            } else if (view.getTag().toString().matches(b2.getTag().toString())) {
                b1.setOnDragListener(dragListener);
                b3.setOnDragListener(dragListener);
                b5.setOnDragListener(dragListener);
                b2.setOnDragListener(null);
                b4.setOnDragListener(null);
                b6.setOnDragListener(null);
                b7.setOnDragListener(null);
                b8.setOnDragListener(null);
                b9.setOnDragListener(null);

            } else if (view.getTag().toString().matches(b3.getTag().toString())) {
                b2.setOnDragListener(dragListener);
                b6.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b3.setOnDragListener(null);
                b4.setOnDragListener(null);
                b5.setOnDragListener(null);
                b7.setOnDragListener(null);
                b8.setOnDragListener(null);
                b9.setOnDragListener(null);


            } else if (view.getTag().toString().matches(b4.getTag().toString())) {
                b1.setOnDragListener(dragListener);
                b5.setOnDragListener(dragListener);
                b7.setOnDragListener(dragListener);
                b2.setOnDragListener(null);
                b3.setOnDragListener(null);
                b4.setOnDragListener(null);
                b6.setOnDragListener(null);
                b8.setOnDragListener(null);
                b9.setOnDragListener(null);

            } else if (view.getTag().toString().matches(b5.getTag().toString())) {
                b2.setOnDragListener(dragListener);
                b4.setOnDragListener(dragListener);
                b6.setOnDragListener(dragListener);
                b8.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b3.setOnDragListener(null);
                b5.setOnDragListener(null);
                b7.setOnDragListener(null);
                b9.setOnDragListener(null);

            } else if (view.getTag().toString().matches(b6.getTag().toString())) {
                b3.setOnDragListener(dragListener);
                b5.setOnDragListener(dragListener);
                b9.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b2.setOnDragListener(null);
                b4.setOnDragListener(null);
                b6.setOnDragListener(null);
                b7.setOnDragListener(null);
                b8.setOnDragListener(null);

            } else if (view.getTag().toString().matches(b7.getTag().toString())) {
                b4.setOnDragListener(dragListener);
                b8.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b2.setOnDragListener(null);
                b3.setOnDragListener(null);
                b5.setOnDragListener(null);
                b6.setOnDragListener(null);
                b7.setOnDragListener(null);
                b9.setOnDragListener(null);
            } else if (view.getTag().toString().matches(b8.getTag().toString())) {
                b7.setOnDragListener(dragListener);
                b5.setOnDragListener(dragListener);
                b9.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b2.setOnDragListener(null);
                b3.setOnDragListener(null);
                b4.setOnDragListener(null);
                b6.setOnDragListener(null);
                b8.setOnDragListener(null);
            } else if (view.getTag().toString().matches(b9.getTag().toString())) {
                b6.setOnDragListener(dragListener);
                b8.setOnDragListener(dragListener);
                b1.setOnDragListener(null);
                b2.setOnDragListener(null);
                b3.setOnDragListener(null);
                b4.setOnDragListener(null);
                b5.setOnDragListener(null);
                b7.setOnDragListener(null);
                b9.setOnDragListener(null);

            }
            return true;
        }


};

private class DragShadow extends View.DragShadowBuilder{

    ColorDrawable greyBox;


    @SuppressWarnings("ResourceAsColor")
    public DragShadow(View v){
        super(v);
        greyBox = new ColorDrawable(R.color.colorPrimaryDark);
    }

    @Override
    public void onDrawShadow(Canvas canvas) {
        greyBox.draw(canvas);
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {

        View v = getView();

        int height = (int) v.getHeight();
        int width = (int) v.getWidth();

        greyBox.setBounds(0,0,width,height);

        shadowSize.set(width,height);

        shadowTouchPoint.set((int) width/2,(int) height/2);
    }
}
OnDragListener dragListener = new OnDragListener() {
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        int dEvent = dragEvent.getAction();

        switch (dEvent) {
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.i("Drag Event", "Entered");
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                Log.i("Drag Event", "Exited");
                break;

            case DragEvent.ACTION_DROP:


                Button b = (Button) view;


                if (b.getText().toString().matches("")) {
                    dragged = (Button) dragEvent.getLocalState();
                    CharSequence a = b.getText();
                    b.setText(dragged.getText());
                    dragged.setText(a);
                    move++;
                    moveleft--;
                    m.setText(Integer.toString(move));
                    ml.setText(Integer.toString(moveleft));
                    condition();
                } else{
                    Toast.makeText(getApplicationContext(),"inserting button should be empty",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;
    }
};

public void condition(){

if(b1.getText().toString().matches("1")
        &&b2.getText().toString().matches("2")
        &&b3.getText().toString().matches("3")
        &&b4.getText().toString().matches("4")
        &&b5.getText().toString().matches("5")
        &&b6.getText().toString().matches("6")
        &&b7.getText().toString().matches("7")
        &&b8.getText().toString().matches("8")){

    Toast toast = Toast.makeText(getApplicationContext(),"GAME OVER",Toast.LENGTH_LONG);
    ViewGroup group = (ViewGroup) toast.getView();
    TextView messageTextView = (TextView) group.getChildAt(0);
    messageTextView.setTextSize(25);
    toast.show();
}

}}