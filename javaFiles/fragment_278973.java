public class CountriesActivity extends Activity {
       protected void onCreate(Bundle icicle) {
           super.onCreate(icicle);
           setContentView(R.layout.countries);

           ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                   android.R.layout.simple_dropdown_item_1line, COUNTRIES);
           AutoCompleteTextView textView = (AutoCompleteTextView)
                   findViewById(R.id.countries_list);
           textView.setAdapter(adapter);
       }

       private static final String[] COUNTRIES = new String[] {
           "Belgium", "France", "Italy", "Germany", "Spain"
       };
    }