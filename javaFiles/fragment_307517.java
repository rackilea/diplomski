package de.scrum_master.stackoverflow.q60167623;

class Child extends Parent {
  @Override
  public void method() {
    super.method();
    // Some additional logic
    System.out.println("child method");
  }

  public static void main(String[] args) {
    new Child().method();
  }
}