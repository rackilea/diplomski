try{
    int val1 = Integer.parseInt(v1.getText().toString());
    int val2 = Integer.parseInt(v2.getText().toString());
 }
catch(NumberFormatException e){
    Toast.makeText(MainActivity.this, "Empty or invalid input", 
      Toast.LENGTH_LONG).show();
    return;
}