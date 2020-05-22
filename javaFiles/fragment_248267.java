public class MainActivity extends Activity {

Button b1; //Gelb
Button b2; //Blau
Button b3; //Grün       
public int colour = 0;
@Override

    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.drawlayout);
    DrawArea da = new DrawArea(this, null);

    b1 = (Button) findViewById(R.id.button1);
    b1.setOnClickListener(handler);
    b2 = (Button) findViewById(R.id.button2);
    b2.setOnClickListener(handler);
    b3 = (Button) findViewById(R.id.button3);
    b3.setOnClickListener(handler);

     public static Integer getColorValue() {

      // Assign your color value
      Integer value=Whatever_value _you_want;

      return value
     }
}