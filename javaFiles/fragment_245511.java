void thisFunctionUsesMyObjects () {
    doIt(param1, param2);
  }

  void thisFunctionToo () {
    doIt(param3, param2);
  }

  private void doIt(p1, p2) {
    new MyOject1(p1, p2).execute();
    new MyObject2(p1).execute();
  }