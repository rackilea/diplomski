for (int i=0; i<sortedArray.length; i++) {
      if (sortedArray[i] < sortedArray[i]+1) { // here you have 
                        // to compare two consecutives array's values... 
                       // in this manner this condition is always true!
            temp = sortedArray[i];
            sortedArray[i] = sortedArray[i]+1; // like previous one
            sortedArray[i+1] = temp; // here --> ArrayOutOfBound when i = 4

            flag = true;
          }
      }