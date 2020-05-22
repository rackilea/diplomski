mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (dbAdapter.updateRecord(
                    selectedId,
                    editText.getText().toString(),
                    editText2.getText().toString(),
                    editText3.getText().toString())
                    ) {
                Log.d("TEST","Row successfully updated.");
                Toast.makeText(getApplicationContext(),"Row Updated.",Toast.LENGTH_LONG).show();
                populateDisplay(selectedId);
            } else {
                Toast.makeText(getApplicationContext(),"Row not Updated",Toast.LENGTH_LONG).show();
            }
            Intent q = new Intent(getApplicationContext(),bills.class);
            startActivity(q);
        }
    });