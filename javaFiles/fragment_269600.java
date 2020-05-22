boolean retFound = false;

    for (int jj = 0; jj < len2; jj++) {
        if (arr1[0] == arr2[jj]) {
            boolean tempFound = true;
            int foundIndex = jj;
            for (int ii = 0; ii < len1; ii++) {
                if (arr1[ii] != arr2[jj+ii]) {
                    tempFound = false;
                    break;
                 }
             }

             if (tempFound) {
                  System.out.println("Found substring " + str1 + " in " + str2 + " at index " + foundIndex);
                  System.out.println("Carrying on to look for further matches...");
                  tempFound = false;
                  retFound = true;
             }
        }
   }

   return retFound;