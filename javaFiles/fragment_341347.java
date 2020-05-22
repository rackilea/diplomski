for (int x = 0; x < 10; x++) 
        { 
            a [x] = 0; 
            for (int y = 0; y < numbers.length; y++) 
            { 
                if (bucket[x][y] != 0) 
                { 
                    tnumbers [y] = 0; 
                    tnumbers [y] = bucket[x][y]; 
                    bucket[x][y] = 0; 
                }                     
            }  
        }