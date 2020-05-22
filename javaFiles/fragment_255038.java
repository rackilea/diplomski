public FractionInterface add(FractionInterface operand) {

    int numerator = num*operand.getDen() + operand.getNum()*den;
    int denominator = den*operand.getDen();

    return new Fraction(numerator, denominator);
}