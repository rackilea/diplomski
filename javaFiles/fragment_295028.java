interface MyFactory {
  SuperType newInstance(Foo arg1, Bar arg2);
}

class BobFactory implements MyFactory {
  public BobType newInstance(Foo arg1, Bar arg2) {
    return new BobType(arg1, arg2);
  }
}

class OtherFactory implements MyFactory {
  public OtherType newInstance(Foo arg1, Bar arg2) {
    return new OtherType(arg1, arg2);
  }
}

void myMethod() {
  MyFactory factory;
  if (v == "bob") {
    factory = new BobFactory();
  } else {
    factory = new OtherFactory();
  }
  SuperType instance = factory.newInstance(arg1, arg2);
}