public static double percent90OrMore (int[] temp)
  {
      int count = 0;
      for ( int i = 0; i < temp.length; i++ )
      {
          if ( temp[i] >= 90 )
          {
              count++;
          }
      }   
      return  (double)count/temp.length;
  }