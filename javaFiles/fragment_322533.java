public void process(String... chunks) {
  if (chunks.length > 0) {
    // Update label with last value in chunks in case multiple results arrive together.
    myLbl.setText(chunks[chunks.length - 1]);
  }
}