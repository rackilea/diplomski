class C1{
  int a = 10;
  int b = 20;

  public C1(){
  }
  void increment(){
      System.out.println("incrementing a and b");
      new C2().inc(a,b);
  }
  void print(){
    System.out.println("Value of a "+ a);
    System.out.println("Value of b "+ b);
  }
}