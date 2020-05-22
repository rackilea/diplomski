try{

  int val = Integer.valueOf(introducir.getText().toString())

}catch(NumberFormatException e){

 Toast.makeText(this, "El valor no es un entero",
 Toast.LENGTH_LONG).show();

}