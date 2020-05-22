abstract class A {
    protected String s;
    //getters and setters...
}

class B extends A {
    public B() { s = "I'm B object"; }
}

class C extends A {
    public C() { s = "I'm C object"; }
}

public class Main {

    public static void main(String[] args) {
        List<A> listA = new ArrayList<A>();
        listA.add(new B());
        listA.add(new C());
        List<B> listB = new ArrayList<B>();
        listB.add(new B());
        listB.add(new C()); //compile error: datatype mismatch

        printListA(listA);
        printListA(listB); //compile error: datatype mismatch
        printListAExtended(listA); //this compiles and executes right
        printListAExtended(listB); //this compiles and executes right
    }

    //this method must receive a List<A> object
    public static void printListA(List<A> listA) {
        for(A a : listA) {
            System.out.println(a.getS());
        }
    }

    //this method must receive a List<A or some class that implements A> object
    //that's why List<A>, List<B> or List<C> or any other List<anything implementing A>
    //can be passed here
    public static void printListAExtended(List<? extends A> listA) {
        for(A a : listA) {
            System.out.println(a.getS());
        }
    }
}