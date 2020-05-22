public class Test {
  public static void main(String[] args) {
    System.out.println(new Test().toString());
    Test sub = new TestSub();
    System.out.println(sub.toString());
    ((TestSub)sub).specialMethod();
  }

  @Override
  public String toString(){
    return "I'm a Test";
  }
}

class TestSub extends Test {
  void specialMethod() {
    System.out.println("I'm a TestSub");
  }
}