private boolean value = false;

public void foo() {
  this.value = true;
}

public void foo2() {
  if (this.value)
    System.out.println("In test");
  else
    System.out.println("in else");
}

public static void main(String[] args) {
  BooleanQuestion b = new BooleanQuestion();
  b.foo();
  b.foo2();
}