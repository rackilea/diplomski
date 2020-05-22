int num = 100000;
int factor = 0;
int rem = 0;
int prime = 0;
boolean isPrime = true;
int j = 2;

for(int i = 1;i < num;++i) {
  rem = num % i;
  if((rem == 0)&&(i != 1)) {
    j = 2; // set j back to start
    isPrime = true; // assume prime before iterating
    while(j < i && isPrime) { // don't let j become equal to i
      if((i % j) == 0) {
        isPrime = false;
      } // don't set isPrime to true until you have completed all iterations
      ++j; 
    }
    if (isPrime) { // now is the time to check!
      prime = i; // remember this prime
    }
  }
}
// output result
System.out.println("largest prime divisor: " + prime);