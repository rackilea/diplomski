public interface Foo{ //interface without plural 's' (question 1)
     public void bar();
 }
 public abstract class Foos(){ // abstract factory with plural 's' (question 1)
    public static Foo createFoo(){
        return new MyFoo();
    }
    private class MyFoo implements Foo{ // a non visible implementation (question 2)
       public void bar(){}
    }
 }