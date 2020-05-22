while( true ) {
    if( !eliminated[current] ) {
        if( ++inkiPinki == m ) {
            break;
        }
    }
    current = (current+1) % n;
}
eliminated[current] = true;
printStatus( eliminated, people );
remainingGuys--;