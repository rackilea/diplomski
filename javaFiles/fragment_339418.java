public class StringSplitterExample {
    public static void main( String[] args ) {
        test( "\".Word.Characters&Numeric&Letters.Typos&Mistypes.\"" );
        System.out.println(); // Line between
        test( "\".Alpha.Beta.Zeta&Iota.\"" );
    }

    public static void test( String Line ) {
        String Formatted = Line.replaceAll( "(^\"[.&]*)|([.&]*\"$)", "" );
        String[] StringGroups = Formatted.split( "\\." );
        String[][] Elements = new String[StringGroups.length][];

        // Loop over the array
        int MaxLength = 0;
        for( int i = 0; i < StringGroups.length; i ++ ) {
            String StrGroup = StringGroups[ i ];
            String[] Group = StrGroup.split( "&" );
            Elements[ i ] = Group;

            // Measure the max length
            if( Group.length > MaxLength ) {
                MaxLength = Group.length;
            }
        }

        for( int i = 0; i < Elements.length; i ++ ) {
            String[] Current = Elements[ i ];
            String[] New = new String[ MaxLength ];

            // Copy existing values into new array, extra values remain null
            System.arraycopy( Current, 0, New, 0, Current.length );
            Elements[ i ] = New;
        }

        for( String[] Group : Elements ) {
            for( String String : Group ) {
                System.out.print( String );
                System.out.print( " " );
            }
            System.out.println();
        }
    }
}