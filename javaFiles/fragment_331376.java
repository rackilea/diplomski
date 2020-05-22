class Spam {
  public static void main(String[] args) {

    int n = Integer.valueOf(args[0]);

    // Declare an array:
    Foo[] myArray;

    // Create an array:
    myArray = new Foo[n];

    // Foo[0] through Foo[n - 1] are now references to Foo objects, initially null.

    // Populate the array:
    for (int i = 0; i < n; i++) {
      myArray[i] = new Foo();
    }

  }
}