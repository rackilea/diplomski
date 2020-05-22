public int[] genrandom(int[] arr, int x) { 

Random randomGenerator = new Random();
  for (int idx = 1; idx <= x; ++idx){
       int randomInt = randomGenerator.nextInt(5000);
          arr[idx] =randomInt;                        }       
     }  
     return arr;
  }