class HelloAgainAdvice {
  @Advice.OnMethodExit
  static void sayHelloAgain() {
    System.out.println("Hello again");
  }
}