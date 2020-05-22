public abstract class A implements GetNames {
   public void doSomething(String a, String b){
       //print 'blabla' + a
       //print 'blablabla' + b
       //concatenate and print
   }
}

public class B extends A {
   public void getNameA(){ return "NameA"; }
   public void getNameB() { return "NameB"; }
   public void doStuff(){
      // class A's doSomething will be called
      doSomething(getNameA(), getNameB());
      //print names
   }
}