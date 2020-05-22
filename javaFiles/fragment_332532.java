interface MyInterface{
  void method();
}

class Super implements MyInterface{
  /* must be implemented. If it's not, then it would NOT also be a MyInterface type */
  public void method(){ ... }
}

class SubClass extends Super {
  // if nothing is added, then only the methods from Super will be a part of SubClass.
  // that means method() is part of this class.
  // It also implements MyInterface, because Super does.
}