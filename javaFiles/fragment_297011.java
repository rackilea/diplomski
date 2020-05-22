public class DisplayInfoExcercise {

    public static void main( String [ ] args )
    {
        int studentInfo [ ] [ ] = { {1, 78, 85}, {2, 83, 90} };

        display( studentInfo );
    }
    public static void display( int array [ ] [ ] )
    {
        for ( int j = 0; j < array.length; j++ ) //
        {
            System.out.println( );

            for ( int k = 0; k <array[j].length; k++)
                System.out.print ( array[j] [k] + "\t" );

        }
        System.out.println( );
    }

}