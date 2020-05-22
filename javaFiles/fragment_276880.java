Spinner spinner1;
String table;
List<String> list;
String selectedItem="";

@Override
protected void onCreate(Bundle savedInstanceState) 
{
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main1);

toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);

spinner1 = (Spinner) findViewById(R.id.spinner1);
list = new ArrayList<String>();
list.add("Table 1");
list.add("Table 2");
list.add("Table 3");
ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, list);
dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner1.setAdapter(dataAdapter);

spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

    public void onItemSelected(AdapterView<?> arg0, View arg1,
            int arg2, long arg3) {
        selectedItem=spinner1.getSelectedItem().toString();


    }

    public void onNothingSelected(AdapterView<?> arg0) {


    }
});

//startButton is connected to button1 on the screen
Button startButton = (Button) findViewById(R.id.button1); 
//Listens for when the start button is clicked
startButton.setOnClickListener(new View.OnClickListener() 
{
    public void onClick(View view) 
    { 
        //Calls the secondActivity method
        //thirdActivity();

     Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
     intent.putExtra("selectedItem",selectedItem);
     startActivity(intent);


    } 
});