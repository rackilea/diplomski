public enum Test {
  A, B, C;
}

public enum Test2 {
  A, B, C;

  private int value ;

  private Test2(){
    value = 0;
  }
}

public enum Test3 {
  A(1), B(2), C(3);
}

public enum Test4 {
  A, B, C;

  public Test4(int value) {}
}