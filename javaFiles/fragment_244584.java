final class Test2$$Lambda$1 implements java.util.function.Function {
      private final Integer arg$1;

      private Test2$$Lambda$1(Integer arg$1){
          this.arg$1 = arg$1;
      }

      // static factory method
      private static java.util.function.Function get$Lambda(Integer i){
            return new Test2$$Lambda$1(i); // instance of self
      }

       public Integer apply(Integer x) {
          return YourClass.lambda$curring$0(this.arg$1, x);    
       }
 }