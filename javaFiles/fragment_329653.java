static int[] division(int dividend, int divisor){

    int result[] = {0, dividend};

    if ( dividend < divisor ){
        return result;
    } else{
        result = division(dividend - divisor, divisor);
        result[0]++;
        return result;
    }

}