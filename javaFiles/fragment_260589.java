public class TagListViewer  extends ListActivity {
    // Make adapter a class variable
    private ArrayAdapter<String> adapter;

    private Button clickBtn;
    EditText textInput;

    // You cannot add items to a primitive String array, we'll convert this to an ArrayList
    String[] resultStr = {"a", "b", "c"}; 
    List<String> list = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tagselection);

        // Add contents of resultStr to the dynamic List
        Collections.addAll(list, resultStr);

        clickBtn = (Button) findViewById(R.id.CreatePL);
        clickBtn.setText("Search");
        textInput = (EditText) findViewById(R.id.textInput);

        // Reflect class variable change and use list instead of resultStr
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        clickBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // This will add the one phrase "ABC"
                //adapter.add("ABC");

                // This will add the contents of textInput
                adapter.add(textInput.getText().toString());
            }
        });
    }
}