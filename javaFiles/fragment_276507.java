class HelloWorldApp {
  public static void main(String[] args) {
    System.out.println("Hello World!"); // Display the string.

    // create object of class
    ClassFromDifferentFile object = new ClassFromDifferentFile();
    // and use its method
    object.methodFromClassFromDifferentFile();

    // or use the static method witout creating object
    ClassFromDifferentFile.staticMethodFromClassFromDifferentFile();
  }
}