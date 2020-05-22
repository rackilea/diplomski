String text = "abcdefghijkl";

    char boxChar[][] = new char[4][3];
    int j,i;

    for (i = 0; i<4; i++)
    {
        for (j=0; j<3; j++)
        {            

            boxChar[i][j] = text.charAt(i*3+j);
            System.out.print(boxChar[i][j]);
        }
        System.out.println();

    }