String string = getString(R.string.mystring);

try{
   int number = Integer.parseInt(string);
} catch (NumberFormatException nfe){
  //.....
}