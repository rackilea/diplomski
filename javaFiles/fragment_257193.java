btnSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
    public void onClick(View v) {
        String firstname = etfirstname.getText().toString();
        String lastname = etlastname.getText().toString();
        boolean isInserted = myDb.insertdata(firstname, lastname);
        if(isInserted == true)
            Toast.makeText(SaveData.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(SaveData.this, "Data not Inserted", Toast.LENGTH_LONG).show();
        }
    });