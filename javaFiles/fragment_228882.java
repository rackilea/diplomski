int result;
for( int x = 0; x < firstList.size(); x++ ) {
    for( int y = 0; y < secondList.size(); y++ ) {
        result = compare( firstList.get( x ), secondList.get( y ) );
        if( result == 0 ) {
            //do stuff
        }
        else if( result < 0 ) {
            //do stuff
        }
        else {
            //do stuff
        }
    }
}