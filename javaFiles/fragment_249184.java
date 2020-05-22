Float oikonomia = null;

try {
  oikonomia = new Float(vprosvasis7.getText().toString());
} 
catch (Exception ignore) {
  // We're ignoring potential exceptions for the example.
  // Cleaner solutions would treat NumberFormatException
  // and NullPointerExceptions here
}

// This happens when we had an exception before
if (oikonomia == null) {
  // [...]
}

// This happens when the above float was correctly parsed
else {
  // [...]
}