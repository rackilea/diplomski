String [][]array2D = new String[5][10];

    for(int r=0; r<array2D.length; r++)
    {
        for(int b=0; b<array2D[r].length; b++)
        {
            array2D[r][b] = Integer.toString(r);
        }
        System.out.println();
    }

    for(int r=0; r<array2D.length; r++)
    {
        for(int b=0; b<array2D[r].length; b++)
        {
            System.out.print(array2D[r][b]);
        }
        System.out.println();
    }

    System.out.println("Prepared By: Diligent Key Presser");