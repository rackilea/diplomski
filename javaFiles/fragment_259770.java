try {
    Calculable calc = new ExpressionBuilder("3+2").build();
}
catch(UnparsableExpressionException ex){
ex.printstacktrace();
}