double handleOperation(String sign, double int1, double int2)
{
    if(sign.equals("+")) {
        return int1 + int2;
    }
    else if(sign.equals("-")) {
        return int1 - int2;
    }
    // others

    return 0;
}

double var1 = 1;
double var2 = 2;
String sign = "+"; 

double variable3 = handleOperation(sign, var1, var2);