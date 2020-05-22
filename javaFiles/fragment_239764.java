public Processor implements Runnable{

  private Foo foo;

  public Processor(Foo foo){
    this.foo = foo;
  }

  public void run() {
     while (true) {
       //some code
       foo.sendRequest(object);
     }
   }
}