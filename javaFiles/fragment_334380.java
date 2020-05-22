public class CalExercises extends Activity {
private ListView myListView;
ArrayAdapter<String> myAdapter;
EditText inputSearch;

List<String> exercises;

//TODO set those 2
Spinner spindif;
Spinner spinmus;

String[] array1;
String[] array2;

Map <String, String[]> map1 = new HashMap<String, String[]>();
Map <String, String[]> map2 = new HashMap<String, String[]>();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_calexercise);

    exercises = new ArrayList<String>(Arrays.asList(new String[]{"Wall Pushup", "Knees Pushup", "Regular Pushup", "Pullup"}));

    myListView = (ListView) findViewById(R.id.exp_list);
    inputSearch = (EditText) findViewById(R.id.itemSearch);
    spindif = (Spinner) findViewById((R.id.filterDif)); 
    spinmus = (Spinner) findViewById((R.id.filterMus)); 

    myAdapter = new ArrayAdapter<String>(this, R.layout.parent_layout, R.id.parent_txt, exercises);
    myListView.setAdapter(myAdapter);
    myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

            String PosItem = (String) arg0.getItemAtPosition(arg2);

            Intent itemIntent = new Intent(getBaseContext(), TempCalEx.class);
            String exIntent = "";

            if ("Wall Pushup".equals(PosItem))
                exIntent = "wallpushup";
            else if ("Knees Pushup".equals(PosItem))
                exIntent = "kneepushup";
            else if ("Regular Pushup".equals(PosItem)) {
                exIntent = "regpushup";
                Toast.makeText(CalExercises.this, "List Detect Test Success - Pushup", Toast.LENGTH_LONG).show();
            } else if ("Pullup".equals(PosItem)) {
                exIntent = "pullup";
                Toast.makeText(CalExercises.this, "List Detect Test Success - Pullup", Toast.LENGTH_LONG).show();
            }

            itemIntent.putExtra("exString", exIntent);
            startActivity(itemIntent);

            inputSearch.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                    CalExercises.this.myAdapter.getFilter().filter(cs);
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                }

                @Override
                public void afterTextChanged(Editable arg0) {
                }
            });


        }

        ;

    });

    // this would be the spinner that selects the "normal", "beginner" etc
    spindif.setOnItemSelectedListener(new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            array1 = map1.get(spinner1.getSelectedItem().toString());
            updateList();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
        }

    });

    spinmus.setOnItemSelectedListener(new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            array2 = map2.get(spinner2.getSelectedItem().toString());
            updateList();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
        }

    });
}

public void updateList() {
    List<Integer> aList =  Arrays.asList(array1);
    List<Integer> bList =  Arrays.asList(array2);
    aList.retainAll(bList);
    exercises = aList;
    myAdapter.notifyDataSetChanged();
}
}