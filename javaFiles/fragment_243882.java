public double toScale( Integer scaleDenominator ){
 if( scaleDenominator == null ){
 throw new NullPointerException( "scaleDenominator must be provided");
 }
 if( scaleDenominator > 0 ){
 throw new IllegalArgumentException( "scaleDenominator must be greater than 0");
 }
 return 1 / (double) scaleDenominator;
}