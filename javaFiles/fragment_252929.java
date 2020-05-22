public class Main extends Activity {
/** Called when the activity is first created. */
private ArrayList<String> array_spinner;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Spinner s = (Spinner) findViewById(R.id.Spinner01);
    array_spinner=new ArrayList<String>();
    array_spinner.add("value");
    array_spinner.add("value 2");
    ArrayAdapter adapter = new ArrayAdapter(this,
    android.R.layout.simple_spinner_item, array_spinner);
    adapter.setNotifyOnChange(true);
    s.setAdapter(adapter);

    s.setLongClickable(true);
    s.setOnLongClickListener(new OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {
            // TODO Auto-generated method stub
            array_spinner.add("value 3");

            return false;

        }}
    );
}