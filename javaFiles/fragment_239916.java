public void AddData () {
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    String name1 = name.getText().toString();
                    String surname1 = surname.getText().toString();
                    String marks1 = marks.getText().toString();

                    if (name1.length() > 0 && surname1.length() > 0 && marks.length() > 0) {

                    boolean isInserted = mydb.insertdata(name1, surname1, marks1);

                    if (isInserted) {
                        Toast.makeText(MainActivity.this, "Data entered successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to enter Data", Toast.LENGTH_LONG).show();
                    }

                    }else if (name == null && surname == null && marks == null)  {
                        Toast.makeText(MainActivity.this, "Please enter Data", Toast.LENGTH_LONG).show();
                    }
            }
        });

}