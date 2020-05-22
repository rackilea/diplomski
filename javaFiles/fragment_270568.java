private ListView lv;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);
    lv = (ListView) findViewById(R.id.listView1);
    // Instanciating an array list (you don't need to do this, you already have yours)
    ArrayList<String> menu_Items = new ArrayList<String>();
    menu_Items.add("Fill Treatment Form");
    menu_Items.add("View Medical History");
    menu_Items.add("View Medication");
    menu_Items.add("View Diet");
    menu_Items.add("View First Aid");
    menu_Items.add("Look Up Map");
    menu_Items.add("Account Settings");
    // This is the array adapter, it takes the context of the activity as a first // parameter, the type of list view as a second parameter and your array as a third parameter
    ArrayAdapter<String> arrayAdapter =      
    new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu_Items);
    lv.setAdapter(arrayAdapter);


    lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
        switch(position){
          case 0:
        Intent i = new Intent(getApplicationContext(), FillTreatmentActivity.class);
                startActivity(i);
        break;
          case 1:
        Intent i = new Intent(getApplicationContext(), MedicalHistoryActivity.class);
            startActivity(i);
        break;
          case 2:
        Intent i = new Intent(getApplicationContext(), MedicationActivity.class);
            startActivity(i);
        break;
          case 3:
        Intent i = new Intent(getApplicationContext(),DietActivity.class);
                startActivity(i);
        break;
          case 4:
        Intent i = new Intent(getApplicationContext(),FirstAidActivity.class);
                startActivity(i);
        break;
          case 5:
        Intent i = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(i);
        break;
          case 6:
        Intent i = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(i);
        break;

        }


        }

    });
}