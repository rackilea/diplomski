public class GameActivity extends Activity {

private DrawV drawView;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   //Declare instance of DrawV ...
   drawView = new DrawV(this);
   // setContentView
   setContentView(drawView);
}}