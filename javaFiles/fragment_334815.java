public boolean checkIfPrime(int num){
   for (int x = 2; x < (int)Math.sqrt(num); x++)
      if (num % x == 0)
          return false;
   return true;
}