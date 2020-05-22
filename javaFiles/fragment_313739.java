import jess.*;
public class Main {
    public static void main( String[] args ) throws Exception {
        Rete rete = new Rete();
        Value val = rete.batch("security.clp");
        Data data = new Data();
        data.setA( 42 );
        data.setB( 24 );
        rete.add( data );
        rete.run();
        System.out.println( "result = " + data.getRes() );
    }
}