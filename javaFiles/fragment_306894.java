import java.util.HashMap;
import java.util.Map;

public class Chain
{
    private static Map< String , String > map;

    public static void main( String args[] )
    {
        map = new HashMap< String , String >();

        map.put( "1" , "2" );
        map.put( "3" , "4" );
        map.put( "2" , "3" );
        map.put( "6" , "2" );

        for ( String key : map.keySet() )
        {
            System.out.print( "(" + key + "," + map.get( key ) + ")" );
            recurse( map.get( key ) );
            System.out.println();
        }
    }

    private static void recurse( String value )
    {
        if ( map.containsKey( value ) )
        {
            System.out.print( " (" + value + "," + map.get( value ) + ")" );
            recurse( map.get( value ) );
        }
    }
}