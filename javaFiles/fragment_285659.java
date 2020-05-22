public class HelloWorld {
  synthetic void sayHelloWorld$origin() {
    System.out.println("Hello World");
  }  

  public void sayHelloWorld() {
    sayHelloWorld$origin();
    sayHelloAgain();
  }

  public void sayHelloAgain() {
    HelloAgainInterceptor.sayHelloAgain();
  }
}