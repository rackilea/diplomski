try {
  SomeObject myObj = arr.get(idx);
  myObj.doSomethingFun();//will fail if this is null!
} catch (NullPointerException e) {
  //do something intelligent like return a fail case.
}