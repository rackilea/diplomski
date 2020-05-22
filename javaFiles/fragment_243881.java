public double toScale( int scaleDenominator ){
 if( scaleDenominator > 0 ){
 throw new IllegalArgumentException( "scaleDenominator must be greater than 0");
 }
 return 1 / (double) scaleDenominator;
}