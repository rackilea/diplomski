Random rand = new Random(System.currentTimeMillis()); 

// warmup
for(int k = 100; k <= 10000; k += 100) 
{
    int[]w = new int[1000];
    for (int i = 0; i < w.length; i++) 
    { 
       int range = Integer.MAX_VALUE; 
       w[i] = rand.nextInt(range); 
       insertionSort(w);
     }
 }