abstract class AbstractFooBarBaz implements FooBarBaz {
     @Override
     public void foo() {
         // NOP by default
     }

     @Override
     public int bar() {
         return 0; // 0 by default
     }

     @Override
     public String baz() {
         return null; // null by default
     }
 }