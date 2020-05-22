public class MainActivity extends Activity {
/** Called when the activity is first created. */
Button b1;
LinearLayout layout;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_act);
    layout=(LinearLayout)findViewById(R.id.layout);
    blueButton=(Button)findViewById(R.id.b1);
    b1.setOnClickListener(new OnClickListener() {

        public void onClick(View arg0) {
        // TODO Auto-generated method stub
        layout.setBackgroundColor(Color.BLUE);

    }
});
}
}