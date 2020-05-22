public class ClassA {
  public method myNonStaticMethod() { ... }
}

public class ClassB {
  private ClassA a;

  public ClassB(ClassA a) {
    this.a = a;  //This makes sure this *object* has a *reference* to an object of *type* ClassA.
  }

  public void looping() {
    //some looping code
    this.a.myNonStaticMethod(); //Actually call the nonstatic method
  }
}