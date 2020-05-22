public interface SomeInterface1 {       
    public default void action(){
        System.out.println("default interface1 method");
    };
}

public interface SomeInterface2 {
    public default void action(){
        System.out.println("default interface2 method");
    };
}

public interface SomeInterface3 extends SomeInterface2{
     public default void action(){
         System.out.println("default interface3 method");
     }
     public default void action2(){
         SomeInterface2.super.action();
     }
  }

public class ClassImplementingInterface implements SomeInterface1,SomeInterface2,SomeInterface3{
    public void action() {
        SomeInterface1.super.action();
        SomeInterface3.super.action2();
        SomeInterface3.super.action();
    }