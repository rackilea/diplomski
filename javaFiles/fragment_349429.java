public abstract class A{
    public abstract void anotherMethod();

    public A(){
        // some stuff..
        specialMethod();
    }

    private final void specialMethod(){
        System.out.println("specialMethod");
        anotherMethod();
    }
}

public class B extends A{
     public B(){
         super();
     }

     public void anotherMethod(){
         System.out.println("anotherMethod");
     }
}