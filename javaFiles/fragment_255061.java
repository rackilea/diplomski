// array with elements
   char[] items = {'a', 'b', 'c', 'd', 'e'};
   int count = 0;

    // first of the "three"
    for (int i = 0; i < upperBound; i++) {
       // second of the "three"
       for (int j = 0; j < upperBound; j++) {
          // can't be identical to i
          if (j == i) 
             continue;

          // third of the "three"
          for (int k = 0; k < upperBound; k++) {
             // can't be identical to i or j
             if (k == i || k ==j) 
                continue;

             // print some display
             System.out.println(items[i] + ", " + items[j] + ", " + items[k]);

             // increment the total count
             count++;
          }
       }
    }



    System.out.println("Total count is " + count);