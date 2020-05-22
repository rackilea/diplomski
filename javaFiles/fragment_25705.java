class ClassToBeTested {

  private final Obj1 a;

  public ClassToBeTested(String anotherVariable) {
   this(new Obj1(anotherVariable));
  }

  ClassToBeTested(Obj1 a) {
    this.a = a;
  }