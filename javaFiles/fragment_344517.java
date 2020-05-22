for (int i = 0; i< 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
           if (firstData[i][j] >= secondData[i][j])
           {
               firstData[i][j] = finalData[i][j]; 
            }
            else if (secondData[i][j] >= firstData[i][j])
            {
                secondData[i][j] = finalData[i][j]          
            }

        }
    }