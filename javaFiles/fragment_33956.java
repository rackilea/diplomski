class A extends ApiClass {
   private ClassContainingDupMethod strategy;
}

class N extends AnotherApiClass {
   private ClassContainingDupMethod strategy;

   public methodCallingDupMethod(){
      strategy.dupMethod();
   }
}

class ClassContainingDupMethod{
   public dupMethod(){;}
}