while(res.moveToNext()){
    String gender = res.getString(3)
    if (gender == "male") {
        RadioButton male = findViewById(R.id.male);
        male.setChecked(true);
    } else {
        RadioButton female = findViewById(R.id.female);
        female.setChecked(true);
    }
}