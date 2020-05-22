while(rslt.next() && i < rowSize)
        {
            for(int j=0;j<columnSize;j++){
                arr[i][j] = rslt.getString(j+1);
            }
            i++;                    
        }