public class MyClass implements Feature {

  public Feature A() {
    //do stuff
    return this; //since MyClass implements Feature we could return this
  }
}