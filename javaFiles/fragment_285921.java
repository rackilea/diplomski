String value;
     final Spinner problems = (Spinner)findViewById((R.id.spinner_problems));
      problems.setOnItemSelectedListener(new OnItemSelectedListener(){

         @Override
         public void onItemSelected(AdapterView<?> adapter, View view1, int pos, long id)
         {
              value= adapter.getItemAtPosition(pos).toString();
         }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    });