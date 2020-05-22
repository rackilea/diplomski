// needed for division
double[] digit = new double[11];
for (int i = 0; i < digit.length; i++)
{
    digit[i] = (double)in.nextInt;
    sum += (int)digit[i];
}

//you can use this variable if needed, if not, ignore it
double[] divisionResult = new double[digit.length / 2];
for(int i = 1; i < digit.length; i += 2) {
    double result = digit[i]; 
    if (result > digit[i + 1]) 
       result = result / digit[i + 1]; 
    else {
       result = digit[i + 1] / result;
    }
    divisionResult[i / 2] = result;
    System.out.println(result);
}