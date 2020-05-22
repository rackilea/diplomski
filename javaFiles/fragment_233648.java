boolean inversedFlag = 2*s>n;
double S = s;
if(inversedFlag)
  S = n-S;

double[] result = new double[n];

for(boolean flag=true; flag; ){
  double[] randomValues = new double[n+1];
  randomValues[n] = S;
  for(int i=1; i<n; i++)
    randomValues[i] = Math.random()*S;
  java.util.Arrays.sort(randomValues);

  for(int i=0; i<n; i++){
    double diff = Math.abs(randomValues[i]-randomValues[i+1]);
    result[i] = inversedFlag ? 1-diff : diff;
  }

  flag=false;
  for(double d:result)
    flag |= d>1;
}

System.out.println("Result values:\n"+java.util.Arrays.toString(result)+"\n");

double resultSum = java.util.Arrays.stream(result).sum();
System.out.println("Sum: "+resultSum );
System.out.println("Is the result sum correct? "+(s==resultSum?"yes":"no"));

System.out.println();
System.out.println("--------------------------------------------------");
System.out.println();