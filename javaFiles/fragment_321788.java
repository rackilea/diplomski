boolean checkPrime(long a)
 {
 long count = 0L;
 for(long op = 2;op*op<=a;op++)  
        if(a%op==0)
                 return false;

  return true;
 }