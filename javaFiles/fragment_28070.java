//this is the PARENT (FIRST) class extended from the CHILDREN (SECOND)
public abstract class FooHelper{
    public abstract void GetFooInt();
}

//this is the CHILD (SECOND!!!) class
public class Foo extends FooHelper{
    public int fooInt;
    public String fooString;

    @Override
    public void GetFooInt() {
       // are you sure you getFooInt method can return a null???
       if(this.getFooInt() == null){  
           this.setFooInt(5);
    }

    //getter/setter below
}