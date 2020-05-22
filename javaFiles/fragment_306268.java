mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        int check = 0;
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if (IsInteracting) {
                Intent intent = getIntent(); //MainActivity
                String itemSelected = mySpinner.getItemAtPosition(mySpinner.getSelectedItemPosition()).toString();

                //TODO: DONE
                prefManager.spinWriteString(itemSelected);
                Toast.makeText(getApplicationContext(), "Constituency News Now Showing", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        }