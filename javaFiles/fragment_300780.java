double[] doubleArray = new double[] { 25, 25 ,25, 10, 15 }; //or any other array
double temp = 100-doubleArray[4]; //or any other specific value in the array
doubleArray[4] = 0;
for (int i; i<doubleArray.length; i++) {
    doubleArray[i] = doubleArray[i]/temp*100;
}