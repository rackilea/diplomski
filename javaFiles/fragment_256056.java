static BigDecimal doIt(BigDecimal input){
    if(input.scale() > 4){
        return input.setScale(4, RoundingMode.HALF_DOWN);
    }
    else{
        return input;
    }
}