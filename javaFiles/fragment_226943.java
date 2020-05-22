public static double 
Power(double base, int exp) throws IllegalArgumentException
{  

    if(exp < 0){
        throw new IllegalArgumentException("Exponent less than zero");
    }
    else if(exp == 0){
        return 1;
    }
    else{

        double returnValue = base * Power(base, exp-1);
        if(returnValue == Double.POSITIVE_INFINITY)
            throw new ArithmeticException("Double overflowed");

        return returnValue;

    }
}