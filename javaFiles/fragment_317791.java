for( x=0;x<3;x++)
 {
    for( i=0;i<4;i++)
    {
        if(rounded[i][x]<395 || rounded[i][x] >405)
        {
            System.out.println("there is an error with point "+(i+1)+"on element"+x+"as the temperature is at"+rounded[i][x]);
        }
    }
  }