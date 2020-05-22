class A {

   B myBClass;
   Callable callable = new Callable {
        @Override
        public void call() {
            //do here what you need what you want to do in B class
        }
   }

   public A() {
       myBClass = new B();
       myBClass.doSomething(callable);
       //Continue doing other tasks
   }

}

class B {

    Callable myCallback;

    public B() {

    }

    public void doSomething(Callable callable) {
        myCallback = callable;
        //does something
        SomethingFinished();
    }

    private void SomethingFinished() {
        myCallback.call();
    }

 }