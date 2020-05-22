public static int[] intersect(BitSet b, int[] a){
    int[] rawResult = new int[a.length];
    int c = 0;
    for(int i : a){
      if(b.get(i)){
        rawResult[c] = i;
        c++;
      }
    }
    int[] result = new int[c];
    System.arraycopy(rawResult, 0, result, 0, c);
    return result;
  }