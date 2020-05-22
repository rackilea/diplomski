public static int numGreater(int[] a, int val) {
     int w = 0;
     for (int i = 0; i < a.length; i++){
       if ((a[i] - val)>0){
       w++;
     }

  return w;
  }