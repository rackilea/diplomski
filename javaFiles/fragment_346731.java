int[] occurrences = new int[10];
     for (int b : array) {
         occurrences[b-1]++;
     }

     for (int i = 0; i < occurences.length; i++) {
         System.out.println(i+1 + " appeared " + occurrences[i] + " times");
     }