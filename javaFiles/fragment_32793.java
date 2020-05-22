public class Xpto{
    protected Fooable x;

    public void foo(){
         Fooable y = x.createInstance();
         // no more operations that depend on y's type.
         // let polymorphism take charge.
         y.foo();
         x.bar();
    }
}