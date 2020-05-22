int ou = 0;
  int present = 0;
  // below are my dummy values
  int[] A = new int[]{5,8,7,6,9,2,3,98};
  int[] B = new int[]{6,9,2,3,63,123};
  int[] iAB = new int[]{6,9,2,3};
  int uAB[] = new int[10];

  for (int j = 0; j < A.length; j++) {
      for (int k = 0; k < uAB.length; k++) {
          if (A[j] == uAB[k]) // check if its already present in the union set
              present++;
      }
      if (ou < uAB.length && present == 0) {
          uAB[ou] = A[j];
          ou++;
      }
      present = 0; // reset the present flag for the next number
  }
 // System.out.println(ou);
 // int ab = ou; no need to do this as ou will point to the place for the next insertion
  for (int j = 0; j < B.length; j++) {
      for (int k = 0; k < uAB.length; k++) {
          if (B[j] == uAB[k]) // check if its already present in the union set
              present++;
      }
      if (ou < uAB.length && present == 0) {
          uAB[ou] = B[j];
          ou++;
      }
      present = 0; // reset the present flag for the next number
  }

  for (int k = 0; k < uAB.length; k++) {

      System.out.println(uAB[k]);

  }