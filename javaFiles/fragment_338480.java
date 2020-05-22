if(primes[index] > a){
    return inList(Arrays.copyOfRange(primes, 0, index),a);
}
if(primes[index]<a){
   return inList(Arrays.copyOfRange(primes, index, primes.length),a);
}