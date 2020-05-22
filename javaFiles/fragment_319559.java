public MyJTextField checkEmpty() {
if (this.getText().equals("") || 
    this.getText().isEmpty()) 
  {
    // throw your exception.
    // print message or whatever you need
    return null;
  } else {
    return this;
  }
}