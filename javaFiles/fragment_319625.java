AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener () {
        onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           updateAge();
        }
    }
    dayAdapter.setOnItemSelectedListener(listener);
    ....

   private void updateAge() {
      int day = spinnerDay.getSelectedItem();
      ....
   }