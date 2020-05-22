for (j=0;j<B.length;j++){//Here i go through my B array
   boolean found = false;

   for (int k = 0; k < A.length; k++) {    // check if element from B was already in A
      if (A[k].equals(B[j])) {       
          found = true;
          break;
      }
   }

   if (!found) {           // if B[j] was not in A, add it to C
      C[i] = B[j];
      i++;
   }
}