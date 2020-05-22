EditText a = (EditText) findViewById(R.id.etPred_density);
String densityValue = a.getText().toString();
Double density = null;
 try
 {
      density = Double.parseDouble(densityValue);
 }
 catch(NumberFormatException e)
 {
     //Not a number, need to handle this
 }
 // Free to carry on with density
 setPredDensity(density);