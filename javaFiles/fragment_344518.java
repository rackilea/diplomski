for (int i = 0; i< 4; i++)
    {
        for(int j = 0; j < 4; j++)
        {

           if (firstData[i][j] >= secondData[i][j] )
           {
               finalData[i][j] = firstData[i][j]; 
            }
            else if (secondData[i][j] >= firstData[i][j])
            {
                finalData[i][j] = secondData[i][j] ;         
            }

        }
    }