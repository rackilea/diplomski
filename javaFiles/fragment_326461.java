spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {
            // TODO Auto-generated method stub
              if(spinner.getSelectedItemPosition() == 0){
                    value = 100;
               }else if(spinner.getSelectedItemPosition() == 1){
                  value = 200;
               }else if(spinner.getSelectedItemPosition() == 2){
                 value = 300;
               }
      }
     }