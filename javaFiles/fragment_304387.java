public static void gaussSeidel(double[][] A, double[] b){
int count = 0;
boolean stop = false;

double[] xNew = new double[b.length]; // x2 = 0, x3 = 0,
double[] xOld = new double[b.length]; 

do{

  for(int i = 0; i < A.length; i++){ 
    double sum = 0.0;
    double sum1 = 0.0;
    for(int j = 0; j < A.length; j++){

      if( j != i)
        sum += (A[i][j]*xOld[j]);

     sum1 += (A[i][j]*xNew[j]);
    }

    xNew[i] = (b[i] - sum - sum1)*(1/A[i][i]);
    System.out.println("X_" + (i+1) + ": " + xNew[i]);
    System.out.println("Error is: " + Math.abs((xNew[i] - xOld[i])));
    System.out.println("");
    count++;

    if(Math.abs(xNew[i] - xOld[i]) > EPSILON){
      xNew[i] = xOld[i];
      }

    else{
      stop = true;}   
  }
}while( !stop && count <= MAX_ITERATIONS);
}