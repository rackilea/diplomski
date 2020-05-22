public class ClassHasANaming {
      private Naming naming;

      public ClassHasANaming(Naming naming) {
          this.naming = naming;
      }

      public void doSomething() {
           naming.someMethodDefinedInTheInterface();
      }
  }