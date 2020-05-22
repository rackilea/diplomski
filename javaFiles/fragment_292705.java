public static ArrayList<Integer> prime(int num){
    ArrayList<Integer> primes = new ArrayList<>();
    ArrayList<Integer> nul = new ArrayList<Integer>();
    nul.add(-1);
        boolean flag=true;
        for(int i = 1; i < num; i++) {
            flag=true;
            for(int j = 2; j < i; j++){
                if (i % j == 0) {
                    flag=false;  // set it to false, if number is not prime
                    break;
                }
            }
            if(flag) {           // If flag was true till this point
                primes.add(i);   // means it is current number is prime. so add it to list
            }
        }
    return primes;
}