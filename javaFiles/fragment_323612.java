String value = ETadresseip1.getText().toString();
try {
   valeur = Short.parseShort(value);
} catch (NumberFormatException e){
   // Error
}