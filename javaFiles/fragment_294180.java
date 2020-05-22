Map<Integer,Integer> externalcallspervalue = new HashMap<>();

// the actual function, renamed to hide avoid you having to change 
// in all the places it was called:

private static int internalfactorial(int n){
    if(n==0){
        return 1;
    } else return n*factorial(n-1);
} 

// and a simple wrapper that does the accounting - and has the same name
// and signature of the original function.

public static int factorial(int n){
   // do the accounting
   Integer ntc = externalcallspervalue.get(i);
   if (ntc==null) { // first time we see this value
      ntc=1;
   } else {
      ntc += 1;
   }
   externalcallspervalue.put(i,ntc);
   // and return the result by calling the hidden internal function
   return internalfactorial(i);
}