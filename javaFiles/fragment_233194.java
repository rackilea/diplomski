public class MainActivity extends Activity {
Draw draw;
Cal cal;
TextView textView;
LinearLayout linearLayout;

public void onCreate(Bundle s) {
    super.onCreate(s);
    setContentView(R.layout.test1);

    linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    cal = new Cal(this);
    cal.cal();

    textView = new TextView(getApplicationContext());
    textView.setText("" + cal.result);
    textView.setTextColor(Color.RED);

    draw = new Draw(this);
    linearLayout.addView(textView);
    linearLayout.addView(draw);
}

public class Draw extends View {
    Paint paint = new Paint();

    Draw(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLUE);
        canvas.drawCircle(120, 120, 40, paint);
    }
}

public class Cal extends View {
    Cal(Context context) {
        super(context);
    }

    public double result;
    double parameter = (Math.pow(40, 2)) * 3.14;

    public void cal() {
        result = Math.sqrt(parameter);

      }
   }
}