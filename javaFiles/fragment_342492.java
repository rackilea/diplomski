//Pseudocode

//find factorial of n given I know already till k

int findFactorial(n, k) {
  int result = 1
  for i n to 1

    if(i==k) 
       break;

    result = result * n;
  return result
}

//factorial(2*n) = facorial(n, k) * factorial(k)