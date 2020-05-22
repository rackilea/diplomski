class B extends A {
  @Override //this will compile fine
  public void dosomething1(A a){ 
    System.out.println("Inside b dosomething1");
  }

  @Override //this will fail compilation
  public void dosomething2(B b){
    System.out.println("Inside b  dosomething2");
  }
}