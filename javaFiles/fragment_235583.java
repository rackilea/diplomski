public static void sort(int[] x) {
  boolean sorted=true;
  int temp;

  while (sorted){
     sorted = false;
     for (int i=0; i < x.length-1; i++) 
        if (x[i] > x[i+1]) {                      
           temp       = x[i];
           x[i]       = x[i+1];
           x[i+1]     = temp;
           sorted = true;
        }          
  }