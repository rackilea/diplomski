try{

  int val = Integer.parseInt(introducir.getText().toString())

}catch(NumberFormatException e){

 Toast.makeText(this, "El valor no es un entero",
 Toast.LENGTH_LONG).show();

}