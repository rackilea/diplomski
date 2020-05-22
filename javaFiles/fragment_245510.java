void thisFunctionUsesMyObjects () {
    MyObject1 obj1 = new MyOject1(param1, param2) ;
    MyObject2 obj2 = new MyObject2(param1) ;
    obj1.execute() ;
    obj2.execute() ;
  }
  void thisFunctionToo () {
    MyObject1 obj1 = new MyOject1(param3, param2) ;
    MyObject2 obj2 = new MyObject2(param3) ;
    obj1.execute() ;
    obj2.execute() ;
  }