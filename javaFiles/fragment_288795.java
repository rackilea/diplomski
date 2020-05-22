public class MyActivity extends Activity {
private ArrayList <String> list = new ArrayList<String>();
private EditText et;
private Spinner spinner;
private ArrayAdapter<String> adapter;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    spinner = (Spinner)findViewById(R.id.spinner);
    et = (EditText)findViewById(R.id.et);
    et.addTextChangedListener(watcher);
    adapter = new ArrayAdapter<String>(MyActivity.this,android.R.layout.simple_spinner_item, list);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
}


private TextWatcher watcher = new TextWatcher() {
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    public void afterTextChanged(Editable s) {
        for (int i = 0; i < s.length(); i ++){
            list.add(String.valueOf(s.charAt(i)));
            adapter.notifyDataSetChanged();
        }
    }
};