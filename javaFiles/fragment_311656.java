private void ClickMe(){


    String name = txtName.getText().toString();
    String age = txtAge.getText().toString();
    //String gender_m = boxGender_m.getText().toString(); //<<<< WRONG
    //String gender_f = boxGender_f.getText().toString(); //<<<< WRONG
    String trauma = boxTrauma.getText().toString();
    String weight = txtName.getText().toString();
    String height = txtName.getText().toString();
    //<<<<<<<<<< ADDED CODE >>>>>>>>>>
    int gender_int_m = 0;
    if (boxGender_m.isChecked()) {
        gender_int_m = 1;
    }
    int gender_int_f = 0;
    if (boxGender_f.isChecked()) {
        gender_int_f = 1;
    }
    //int gender_int_m = Integer.parseInt(gender_m); //<<<< REDUNDANT
    //int gender_int_f = Integer.parseInt(gender_f); //<<<< REDUNDANT
    int trauma_int = Integer.parseInt(trauma);
    int weight_int = Integer.parseInt(weight);
    int age_int = Integer.parseInt(age);
    int height_int = Integer.parseInt(height);
    Boolean result = myDb.insertData( name, age_int, gender_int_m, gender_int_f, weight_int, height_int, trauma_int);
    if (result == true){
        Toast.makeText(this, "Data Inserted Successfully",Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(this, "Data Inserted Failed",Toast.LENGTH_SHORT).show();
    }
    Intent i = new Intent(this,ResultData.class);
    startActivity(i);
}}