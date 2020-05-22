public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myEditText et = (myEditText) findViewById(R.id.something_dummy);
    et.setEditTextEmpty();

}

}