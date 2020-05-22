public class TestClass extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button yourButton = (Button)findViewById(R.id.menu_legalnotes);
        //If you have more buttons,
        Button secondButton = (Button)findViewById(R.id.secondButtonID);
        //Register more buttons if you have.

    }