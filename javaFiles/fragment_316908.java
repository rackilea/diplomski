Intent i = getIntent();
Bundle b = i.getBundleExtra("myDataFromGetReady"); 

// now get the data from the Bundle: 
all_exercises = (ArrayList<String>) b.getSerializable("all_exercises"); 
rounds= b.getInt("total_rounds", -1);

exercise_name = (TextView) findViewById(R.id.exercise_name);
exercise_name.setText(all_exercises.get(0));

final Button done=(Button) findViewById(R.id.done);

// ... and so on ...