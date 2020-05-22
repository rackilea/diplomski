try {
   formatNumber("notAnumber");
   fail("Expected NumberFormatException");
catch(NumberFormatException e) {
  // no-op (pass)
}