double original( double[] window, int i, int windowEnd, int pStart ) {
    double fftVal = Math.sqrt(
            ( window[ i * 2 ] * window[ i * 2 ] )
                    + ( window[ i * 2 + 1 ] * window[ i * 2 + 1 ] )
    );
    return 20 * Math.log10(
            Math.abs( fftVal ) / ( windowEnd - pStart ) );
}