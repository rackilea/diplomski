/**
   * Returns ith permutation of the n numbers [from, ..., to]
   * (Note that n == to - from + 1).
   * permutations are numbered from 0 to n!-1, if i is outside this
   * range it is treated as i%n! 
   * @param i
   * @param from
   * @param n
   * @return
   */
  public static int[] perm(long i, int from, int to)
  {
    // method specification numbers permutations from 0 to n!-1.
    // If you wanted them numbered from 1 to n!, uncomment this line.
    //  i -= 1;
    int n = to - from + 1;

    int[] initArr  = new int[n];             // numbers [from, ..., to]
    int[] finalArr = new int[n];             // permutation of numbers [from, ..., to]

    // populate initial array
    for (int k=0; k<n; k++)
      initArr[k] = k+from;

    // compute return array, element by element
    for (int k=0; k<n; k++) {
      int index = (int) ((i%factorial(n-k)) / factorial(n-k-1));

      // find the index_th element from the initial array, and
      // "remove" it by setting its value to -1
      int m = convertIndex(initArr, index);
      finalArr[k] = initArr[m];
      initArr[m] = -1;
    }

    return finalArr;
  }


  /** 
   * Helper method used by perm.
   * Find the index of the index_th element of arr, when values equal to -1 are skipped.
   * e.g. if arr = [20, 18, -1, 19], then convertIndex(arr, 2) returns 3.
   */
  private static int convertIndex(int[] arr, int index)
  {
    int m=-1;
    while (index>=0) {
      m++;
      if (arr[m] != -1)
        index--;
    }

    return m;
  }