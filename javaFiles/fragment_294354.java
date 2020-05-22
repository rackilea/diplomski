String prvoString = textViewRezultat1RMPotisakSKlupe.getText().toString();
Double prvo; 
if(prvoString != null) { //shouldn't occur
  try {
    prvo = Double.parseDouble(prvoString); 
  } catch (NumberFormatException ex) { //inputs like "" or "banana"
     //Tell the user he is entering invalid input
  }
}