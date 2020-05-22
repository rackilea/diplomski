int pos = 1;
      int[][] listTwo = new int[10][5];
      for (int r = 0; r < listOne.length; r++) {
         int[] v = listOne[r];
         listTwo[v[0]][v[1]] = pos++;
      }