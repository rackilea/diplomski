constantGameBoard.rowcolumnNumber has been neglected , this is the issue. Now it's resolved

public static void userInputOnBoard(int numberRC, int row , int column ) {



        for(int i = 0 ; i < constantGameBoard.rowcolumnNumber ; i++)
        {
            System.out.println("print 1" + "value i " + i);
            for(int j = 0 ; j < constantGameBoard.rowcolumnNumber ; j++)
            {
                System.out.println("print 2" + " value j" + j);
                if( i == row && j == column)
                {
                    System.out.println("print 3");
                    if(numberRC == 1)
                    {
                        System.out.println("print 4");
                        constantGameBoard.inputArray[i][j]= 1;
                    }
                    else
                    {
                        System.out.println("print 5");
                        constantGameBoard.inputArray[i][j]=0 ;
                    }

                }


            }
        }


}