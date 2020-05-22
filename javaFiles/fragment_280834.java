static void partition(int[] ar) {
      List<Integer> smallerValues = new ArrayList<Integer>();
      List<Integer> biggerValues = new ArrayList<Integer>();
      int toPartitionAround = ar[0];
      for(int c=1;c<ar.length;c++) {
          if(ar[c] <= toPartitionAround) {
              smallerValues.add(ar[c]);
          } else {
              biggerValues.add(ar[c]);
          }
      }
      for(int c=0;c<smallerValues.size();c++) {
          ar[c] = smallerValues.get(c);
      }
      ar[smallerValues.size()] = toPartitionAround;
      for(int m=0;m<biggerValues.size();m++) {
          ar[m + smallerValues.size() + 1] = biggerValues.get(m);
      }
      printArray(ar); 
   }