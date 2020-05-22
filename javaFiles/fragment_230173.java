double variant( double[] window, int i, int windowEnd, int pStart ) {

    // w[2i]^2 + w[2i+1]^2
    double temp1 = window[ i * 2 ] * window[ i * 2 ]
            + window[ i * 2 + 1 ] * window[ i * 2 + 1 ];

    // apply log(sqrt(X)) == log(X^0.5) == 0.5 log(X)
    double temp2 = 0.5 * Math.log10( temp1 );

    // calculate the value of Math.log10( windowEnd - pStart )
    // (and cache it outside of the function) 
    double tempConst3 = Math.log10( windowEnd - pStart );

    // apply log(X/Y) == log(X) - log(Y)
    double temp4 = temp2 - tempConst3;

    return 20 * temp4;
}