class Base {

    static public int myVar;

}


class Derived extends Base {

    static public int myVar2;

    static
    {
        Base.myVar = 10;
    }
}


public class Main {
    public static void main( String[] args ) throws Exception {
        System.out.println(Derived.myVar2);
        System.out.println(Base.myVar);
    }
}