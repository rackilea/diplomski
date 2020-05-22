List<LocalDate> tooEarly = new ArrayList<>();
List<LocalDate> tooLate = new ArrayList<>();
List<LocalDate> justRight = new ArrayList<>();

for (String date : dates) {
    YearMonth ym = YearMonth.from( date );
    if( ym.isBefore( start ) ) {
        tooEarly.add( date );
    } else if( ! ym.isBefore( stop ) ) {  // Using Half-Open approach where ending is *exclusive*. Use “( ym.isAfter( stop ) )” if you want inclusive ending.
        tooLate.add( date );
    } else {
        justRight.add( date );
    }
    System.out.println( "ERROR unexpectedly went beyond the if-else-else." ); 
}