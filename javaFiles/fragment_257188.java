public Page conditionalAction( boolean condition ) {
    if ( condition ) {
        return new Page1();
    } else {
        return new Page2();
    }
}