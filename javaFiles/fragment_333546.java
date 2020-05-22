Collections.sort(segment, new Comparator<int[]>() {
         public int compare(int[] a, int[] b) {
              if(a[0] - b[0]==0) //if equals
              {
                  return a[1]-b[1];//recompare 
              }
              else
                  return a[0]-b[0];
         }
    });