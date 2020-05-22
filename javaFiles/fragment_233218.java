public void addItemsOnSpinner(String value) 
    { 
     int position = 0; 
     project=(Spinner)findViewById(R.id.SpinnerProject); 
     List<String> list = new ArrayList<String>(); 

     list.add(position,"TRN-XXX-XXX"); 
     list.add("Pro-XXX-XXX"); 

     for(int i=0; i<list.size() ; i++){
         if(list.get(i).equalsIgnoreCase(value)){
             position = i;
             break;
         }
     }


    ArrayAdapter<String> adapter = new ArrayAdapter<String>      (getApplicationContext(),R.layout.spinner_item, list); 
     //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
    project.setAdapter(adapter); 

    project.setSelection(position); 
   }