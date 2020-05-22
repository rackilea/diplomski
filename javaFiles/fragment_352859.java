public static class BooleanHolder {
  public Boolean value;
}

private static void foo(BooleanHolder test) {
  test.value = true;
}

private static void foo2(BooleanHolder test) {
  if (test.value)
    System.out.println("In test");
  else
    System.out.println("in else");
}

public static void main(String[] args) {
  BooleanHolder test = new BooleanHolder();
  test.value = false;
  foo(test);
  foo2(test);
}