class Foo implements Caller{//the class who calls the method
  @Override
  @CatchGroup(catchers={ 
      @Catch(targetCatchHandler=Bar.class,targetException=ArithmeticException.class),
      @Catch(targetCatchHandler=Bar.class,targetException=NullPointerException.class)})
  public void callMethod()throws Throwable {
    int a=0,b=10;
    System.out.println(b/a);
  }
  public static void main(String[] args) throws Exception {
    Foo foo=new Foo();
    MethodCaller.callMethod(foo);
  }
}