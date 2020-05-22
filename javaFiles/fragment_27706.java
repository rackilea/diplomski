private static void sortInDescending(int[] arrayObj) 
    {           
        int n = arrayObj.length;
        int temp = 0;

        for(int i=0; i < n; i++)
        {
            for(int j=1; j < (n-i); j++)
            {                                   
                if(arrayObj[j-1] < arrayObj[j])
                {
                    temp = arrayObj[j-1];
                    arrayObj[j-1] = arrayObj[j];
                    arrayObj[j] = temp;
                }                         
            }
        }   
    }