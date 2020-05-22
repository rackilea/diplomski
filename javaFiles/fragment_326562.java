int trailingZerosOfFactorial(int number){
  if(number == 0){
    return 0;
  }
  int nrIntegerDividedByFive = number/5;
  return nrIntegerDividedByFive + trailingZerosOfFactorial(nrIntegerDividedByFive);
}