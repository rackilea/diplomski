int getNewScrollSpeed( int scrollPaneHeight ){

    // you'll have to play around with the multiplier value to make it work for you
    // here I just chose 0.5 as an example

    return (int) ( scrollPaneHeight * 0.5 );

}