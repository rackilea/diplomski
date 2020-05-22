class SecondD {
    BigDecimal[] singleValued= new BigDecimal[5] ;
    ArrayList<BigDecimal>[] multiValued= new ArrayList<BigDecimal>[2] ;
    {
        multiValued[0]= new ArrayList<BigDecimal>() ;
        multiValued[1]= new ArrayList<BigDecimal>() ;
    }
}
ArrayList<SecondD> data= new ArrayList<SecondD>() ;