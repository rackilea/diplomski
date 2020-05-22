import java.util.*;

public class Foo {

    public static void main( String[] args ) {


        String input = "AND 3,    4, 5   ; some comments";
        List<String> parts = new ArrayList<String>();

        // removing comments
        input = input.split( ";" )[0];

        // splits using spaces
        String[] firstPass = input.trim().split( " " );

        for ( String s : firstPass ) {

            // the current part cannot be empty
            if ( !s.trim().isEmpty() ) {

                // splits using comma
                String[] secondPass = s.split( "," );

                for ( String ss : secondPass ) {
                    parts.add( ss.replace( ",", "" ) );
                }

                // verifies if the current part has a comma
                // and if so, inserts it as a part
                if ( s.contains( "," ) ) {
                    parts.add( "," );
                }

            }

        }

        for ( String a : parts ) {
            System.out.println( a );
        }

    }

}