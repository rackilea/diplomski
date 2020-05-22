MyClass<String> myObj = new MyClass<String>();
result = myObj.doSomething(port, host, res -> {
  if (res.succeeded()) {
    System.out.println("I did a thing!");
  } else {
    System.out.println("I did not do a thing!");
  }
});