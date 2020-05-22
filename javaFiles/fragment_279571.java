if( userMonthName.equalsIgnoreCase("year") )
{
    // User entered "year" - print out all values
    for( i=0; i < NUM_MONTHS; i++ ) 
    {
         System.out.println( monthName[i] + " " + avgMonthTemp[i] );
    }

     Arrays.sort( avgMonthTemp );
     System.out.println( "Minimum = " + avgMonthTemp[0] );
     System.out.println( "Maximum = " + avgMonthTemp[avgMonthTemp.length-1] ); 
}
else
{
    // Did the user enter a month name?  If so print just that
    for( i=0; i < NUM_MONTHS; i++ ) 
    {
        if ( userMonthName.equalsIgnoreCase( monthName[i] ) ) 
        {
             System.out.println( monthName[i] + " " + avgMonthTemp[i] );
        }
    }
}