String userInput = ...;
boolean countryExists = false;
for( CountryEnum country : CountryEnum.values() ) {
    if( userInput.equalsIgnoreCase( country.name() ) ) {
        countryExists = true;
        break;
    }
}
if( !countryExists ) {
    System.err.println( "No such country" );
    // exit program here or throw some exception
}