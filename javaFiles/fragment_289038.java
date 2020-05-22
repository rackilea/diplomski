EditText number = (EditText) findViewById(R.id.editText2);
String newNumber = number.getText().toString();

f(!number.getText().toString().isEmpty()){
        Log.d("TAG", newNumber);
        newNumber = newNumber.replaceFirst("06", "3876");
        Log.d("TAG", newNumber);
}