public class Second extends AppCompatActivity {

    ListView listview;
    String[] pStyle = new String[]{
            "Fashion",
            "HDR",
            "Hi Speed",
            "Landscape",
            "Portrait",
            "Street",
            "Wedding"

    };
    private static final int MAX_SELECTABLE = 3;
    List<String> mSelected = new ArrayList<>();

    SparseBooleanArray sparseBooleanArray;
    private int numberOfCheckboxesChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listview = (ListView) findViewById(R.id.listView2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, pStyle);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                CheckedTextView ctv = (CheckedTextView) view;
                if (ctv.isChecked()) {
                    mSelected.remove(pStyle[pos]);
                    ctv.setChecked(false);
                } else if (mSelected.size() < MAX_SELECTABLE) {
                    mSelected.add(pStyle[pos]);
                    ctv.setChecked(true);
                } else {
                    Toast.makeText(Second.this, "You can\'t select more than " + MAX_SELECTABLE + " items", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}