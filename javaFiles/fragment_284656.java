while(num1 >= rows || num2 >= columns)
// ^ instead of if         ^ (additionally changed comparison)
{
     System.out.println("This space is off the board, try again.");
     int[] values = inputMove();
     //           ^  can assign directly,
     //              (the array you created previously is just GC'ed)
     num1 = values[0];
     num2 = values[1];
}
//code to place a value in grid[num1][num2]