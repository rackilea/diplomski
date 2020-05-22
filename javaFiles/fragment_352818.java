public class Outer {

private int someVariable=0;

public void someMethod(){
    ExtendsInner ei = new ExtendsInner();
    ei.innerMethod();
    System.out.println(someVariable);
}

private void anotherMethod(){
    someVariable++;
}

public abstract class Inner {
    public abstract void innerMethod();
}

public class ExtendsInner extends Inner{
    public void innerMethod(){
        anotherMethod();
        someVariable++;
    }
}

public static void main(String[] args){
    Outer o = new Outer();
    o.someMethod();
}
}