double count = 10.0;   // is 10.0 for your problem
double sum1 = 0.0;    // sum of the numbers
double sum2 = 0.0;    // sum of the squares
int i;
for (i=0; i < 10; i++) {
  System.out.println("Enter 10 numbers: ");
  double n = input.nextDouble();
  sum1 += n;
  sum2 += n * n;
}
double average = sum1 / count;
double variance = (count * sum2 - sum1 * sum1) / (count * count);
double stdev = Math.sqrt(variance);