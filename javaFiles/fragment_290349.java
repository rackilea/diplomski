class TheClass {
   MyFuncBehavior myFuncer = new MyFuncBehavior();
   void myFunc() {
      myFuncer.myFunc();
   }
}

class MyFuncBehavior {
   private static SomeStruct someStruct = new SomeStruct();

   public void myFunc() {
     someStruct.setState(INITIALIZED);
     goDoSomethingInteresting(MY_COMMAND,someStruct);
   }
}