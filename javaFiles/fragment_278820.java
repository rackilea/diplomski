for (int i=0; i<sortedArray.length - 1; i++) {
      if (sortedArray[i] < sortedArray[i+1]) {
            temp = sortedArray[i];
            sortedArray[i] = sortedArray[i+1];
            sortedArray[i+1] = temp;

            flag = true;
          }
      }