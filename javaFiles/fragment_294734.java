//Make these variables global so that it can be accessed in onClickListner.
Integer[] items = new Integer[]{1,2,3,4};
int multiple=0;
ImageView imageView;
TextView tot_calories;
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.items_details);
      Spinner mspin=(Spinner) findViewById(R.id.spinner1);
      ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
      mspin.setAdapter(adapter);

      TextView name_select=(TextView)findViewById(R.id.SelectedName);
      name_select.setText(constant.food_items[constant.SelectedIndex]);
      imageView =(ImageView) findViewById(R.id.imagedetail);
      UpdateImage(constant.food_items[constant.SelectedIndex]);
      TextView calories=(TextView)findViewById(R.id.calories111);
      calories.setText(constant.food_calories[constant.index]+"");

      tot_calories=(TextView)findViewById(R.id.caloriestotal);
      mspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()     {
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
      // Your code here
            multiple=items[i]*constant.food_calories[constant.index];
            tot_calories.setText("update Value is: "+multiple);
      } 

      public void onNothingSelected(AdapterView<?> adapterView) {
      return;
      }

  });
  }