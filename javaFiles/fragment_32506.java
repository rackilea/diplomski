public static  boolean Isprime(int x){
    boolean isprime = true;

    for(int m=2;m<=Math.sqrt(x);m++){

        int temp = x%m;
        if(temp == 0){
            isprime = false;
            break;
            }
      }
    return isprime;

  }