public class MyActivity extends Activity{
            .
            all your activity stuff here
            .
            .
public class Tab3 extends View implements OnTouchListener{

LinearLayout myLayout;
int x1, x2, y1, y2, x, y;
// x, y;
Rect rect2 = new Rect();

public Tab3(Context context, AttributeSet attrs)
{
    super (context, attrs);

    myLayout = (LinearLayout) findViewById(R.id.myLayout);

    x1 = 0;
    x2 = 300;               //1280 by 748
    y1 = 0;
    y2 = 300;




    setFocusable(true);
    setFocusableInTouchMode(true); 
    setOnTouchListener(this);
    requestFocus();
}

@Override
protected void onDraw(Canvas canvas) 
{
    super.onDraw(canvas);

    Paint blue = new Paint();
    blue.setColor(Color.BLUE);
    canvas.drawRect(rect2, blue);
    rect2.set(x1, y1, x2, y2);

    invalidate();
}

@Override
public boolean onTouch(View v, MotionEvent event) 
{
    if(rect2.contains((int) event.getX(),(int) event.getY()))
    {
        Intent SectionManager = new Intent (MyActivity.this, SectionManager.class);
        startActivity (SectionManager);
    }
    return true;
}
} //end Tab3 Class
} //end MyActivity