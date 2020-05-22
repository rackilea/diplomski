public class HomeActivity extends Activity{

private ImageView head;


 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        head=  (ImageView) findViewById(R.id.head);
    }

public void blue(View view) {
    head.bringToFront();
    blueOn = true;
    redOn = false;
}

}