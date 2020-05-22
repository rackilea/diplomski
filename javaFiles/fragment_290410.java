public void testMethod(final int canAccess, int cantAccess) {
  final String test = otherView.getText().toString();
  myView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      // Cannot access cantAccess, because it's not final
      if (test.length == 0) { // can access
        // do something
      }
    }
}