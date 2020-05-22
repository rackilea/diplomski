public double pow(double num1, double num2) {
  double result = 1;
  for (int i = 0; i < num2; i++)
    result *= num1;
  return result;
}