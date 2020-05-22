for (g = 0; g < 3; g++)
        for (r = 0; r < 10; r++) {
        ┆   for (c = 0; c < 10; c++)
        ┆       seating[g][r][c] = g * r * c;
        ┆   {
        ┆   ╻  for (g = 0; g < 3; g++)
        ┆   ╻       for (r = 0; r < 10; r++) {
        ┆   ╻           for (c = 0; c < 10; c++) {
        ┆   ╻               System.out.print(seating[g][r][c]);
        ┆   ╻           }
        ┆   ╻           System.out.println();
        ┆   ╻       }
        ┆   ╻   System.out.println();
        ┆   }
        }