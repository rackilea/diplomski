for (int i=0; i<5; i++)
    {
        for (int j=0; j<=i;j++)
        {   
            if(i==j) { //then print the number and a new line
                System.out.println(array1[i][j]);
            }
            else {
                System.out.print(" "); //pads the line with spaces otherwise
            }
        }
    }