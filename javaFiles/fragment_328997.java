class MyString {

  String delegate; // The actual string you delegate to from your class

  public MyString(String delegate) {
    this.delegate = delegate; // Assign the string that backs your class
  }

  int length() {
    return delegate.length(); // Delegate the method call to the string
  }

  // other methods that delegate to the string field
}