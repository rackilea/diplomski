abstract class GenericContainer {
    public GenericChild child;       
}

abstract class GenericChild {
    public int prop1=1 ;
}

class SpecialChild extends GenericChild {
    public int prop1=2;
}

class SpecialContainer extends GenericContainer {
    public SpecialChild child;
}

public class Main {

    public static void main( String ... args ) {

        GenericContainer container = new SpecialContainer();
        container.child = new SpecialChild();

        System.out.println( container.child.prop1 );

        SpecialChild child = (SpecialChild) container.child;        
        System.out.println( child.prop1 );
    }

}