int calculateHeight(int width, double aspect) {

    if( aspect <= 0.0 ) {
        // handle this error condition
    }
    return (int)Math.round(width / aspect); 
}