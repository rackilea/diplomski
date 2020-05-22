Spinner m1ssspinner = (Spinner)findViewById(R.id.m1_ss_spinner);        
ArrayAdapter<CharSequence> m1ssadapter = ArrayAdapter.createFromResource(this, R.array.m1_ss_list, R.layout.my_normal_spinner_style);            
m1ssadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
m1ssspinner.setAdapter(m1ssadapter); 

Spinner m1sqs1spinner = (Spinner)findViewById(R.id.m1_sqs1_spinner);        
ArrayAdapter<CharSequence> m1sqs1adapter = ArrayAdapter.createFromResource(this, R.array.m1_sqs1_list, R.layout.my_normal_spinner_style);            
m1sqs1adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);            
m1sqs1spinner.setAdapter(m1sqs1adapter);