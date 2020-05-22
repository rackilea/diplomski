public RationalNumber(int num, int den)
{
    //setNumerator(num);
    //setDenominator(den);
    int gcf= greatestCommonFactor(num, den);
    setNumerator(num/gcf);
    setDenominator(den/gcf);
}