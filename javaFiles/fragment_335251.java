for(int j = 1; j <= 10; j++ )
            {
                if (i % 10 == i) {
         System.out.printf("%-2d * %-2d = %-2d", j, i + i + 1, i   * j + 1);
         System.out.printf("%10d * %d = %d\n", j, i + i + 2, i * j + 1);

         printWriter.printf("%-2d * %-2d = %-2d", j, i + i + 1, i
                            * j + 1);
         printWriter.printf("%10d * %d = %d\n", j, i + i + 2, i
                            * j + 1);
                }