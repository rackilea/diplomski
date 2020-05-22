int [][] array = new int [random.nextInt(maxRowCol)][];

      for (int i = 0; i < array.length; i++) {
         array[i] = new int[random.nextInt(maxRowCol)];
         for (int j = 0; j < array[i].length; j++) {
           array[i][j] = random.nextInt(9) + 1;
         }
      }