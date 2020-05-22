for (int i = 0; i < row; i++)    //for loop to repeat question for how ever many rows
    {
        System.out.print("Enter the danger in row " + i + ", seprated by spaces: ");   //what's the danger of this row
        for (int j = 0; j < column; j++)    //for every row, column space
        {
            mazePrint[i][j] = keyboard.next();
            mazeMath[i][j] = Integer.parseInt(mazePrint[i][j]);
        }
    }