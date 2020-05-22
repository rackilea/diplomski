ArrayList<String> countries=new ArrayList<>();
        countries.add("Select Country");
        countries.add("India");
        countries.add("China");
        countries.add("USA");
        countries.add("Africa");
        countries.add("Russia");

    ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, countries);
    RegisterUserType.setAdapter(adapter);

    RegisterUserType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position==0){
                Toast.makeText(getApplicationContext(),"No Item Selected",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(),"Item Selected = "+parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });