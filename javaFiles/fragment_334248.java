Class A {
    private List<B> listOfB;

    ...

   private void method() {
       listOfB.forEach(B::doSomething);
   }
}