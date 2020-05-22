abstract class Common{
...
}

class Foo{
  private Common currentReference;

  public Foo(...){
    currentReference = new Foo1();
  }

  public Foo changeReferenceToClass(Class clazz){
    ...
    currentReference = clazz.newInstance();
    ...
    return this;
  }

  public <T extends Common> T getReference()
  {
    return (T) currentReference;
  }
}

class Foo1 extends Common{
...
}

class Foo2 extends Common{
...
}

Foo f=new Foo( ... );
Foo g=f;
g=g.changeReferenceToClass(Foo2.class);