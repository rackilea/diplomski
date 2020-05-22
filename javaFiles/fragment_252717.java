Bar bar = new Bar();
bar.doThis().doThat(25) ;

class Bar{
  public Foo doThis() {
    Foo foo=new Foo();
    //do some thing using foo

    return foo;
  }
}

class Foo() {

  void doThat(int number){
    // can do anything using parameter number and return anything
  }

}