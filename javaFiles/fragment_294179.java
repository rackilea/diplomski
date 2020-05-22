static int thenumberoftimesiwascalled;

public static int factorial(int n){
    thenumberoftimesiwascalled++;
    if(n==0){
        return 1;
    } else return n*factorial(n-1);
} 

...


Map<Integer,Integer> thenumberoftimeshewascalled = new HashMap<>();
for (int i=1;i+100;i++) {
   // reset counter
   thenumberoftimesiwascalled = 0;
   // calculate
   int result = factorial(i);
   System.out.println("called " + thenumberoftimesiwascalled + " times for " + i);
   // stash in Map
   thenumberoftimeshewascalled.put(i,result);
}