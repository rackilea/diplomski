Class Foo{
  ArrayList<Boo> boovar = new ArrayList<Boo>();

  //copy constructor
  public Foo(Foo sourceFoo){
    for (Boo aBoo:sourceFoo.boovar){
      boovar.add(new Boo(aBoo)); 
    }
  }

}