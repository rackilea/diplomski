MyClass myObj = new MyClass(); //Generic type warning
result = myObj.doSomething(port, host, res -> {
  if (res.succeeded()) { //Error
    System.out.println("I did a thing!");
  } else {
    System.out.println("I did not do a thing!");
  }
});