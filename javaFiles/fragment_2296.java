public class Test3 {

  void printMe() {
    printMe();
  }

  public static void main(String[] args) {
    Test3 test = new Test3();
    test.printMe();
  }

}