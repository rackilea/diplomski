interface I { 
   void doSomething();
 }
class A implements I {
   void doSomething(){
    //do something here 
} 
 }
class B implements I { 

   void doSomething(){
    //do something here 
} 
 }

interface OverrideMe {
   void method(I parameter)
}

class Overriding implements OverrideMe {
   @Override
   void method(I parameter) {
       parameter.doSomething();
   }
}