public class MySpinner extends Activity implements OnItemSelectedListener{
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      Spinner spinner = (Spinner) findViewById(R.id.coffee_spinner);
      spinner.setOnItemSelectedListener(this);
      List<String> categories = new ArrayList<String>();
        categories.add("Mars($12 billions)"); //0
        categories.add("Earth ($99 billions)"); //1
        categories.add("Jupiter ($13 billions)"); //2
ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

      // Drop down layout style - list view with radio button
      dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

      // attaching data adapter to spinner
      spinner.setAdapter(dataAdapter);
 }
 @Override
   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      // On selecting a spinner item
      String item = parent.getItemAtPosition(position).toString();

      // Showing selected spinner item
      Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
   }
   public void onNothingSelected(AdapterView<?> arg0) {
      // TODO Auto-generated method stub
   }
}