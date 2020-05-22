btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (edtName.getText().toString().trim().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please provide your students name", Toast.LENGTH_SHORT).show();
        } else{
            try {
                if (edtAge.getText().toString().trim().length() != 0) {
                    String name = edtName.getText().toString().trim();
                    String age = edtAge.getText().toString().trim();
                    String query = "Select * From STUDENTS where name = '"+name+"'";
                    if(dbManager.fetch().getCount()>0){
                        Toast.makeText(getApplicationContext(), "Already Exist!", Toast.LENGTH_SHORT).show();
                    }else{
                        dbManager.insert(name, age);
                        Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();                           
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "please provide student age!", Toast.LENGTH_SHORT).show();                           
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }  
});