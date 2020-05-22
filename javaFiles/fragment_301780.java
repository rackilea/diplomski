function hello() {
  var x = 42; // notice the closure over x in the success handler
  stuffExecutor.execute(new JavaAdapter(Packages.my.package.StuffExecutor.Listener, {
    success: function (result) { println("Success: " + (result + x)); },
    failure: function (reason) { println("Failure: " + reason; }
  }));
  println("Starting to execute stuff...");
}