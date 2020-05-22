public static boolean isNumberInArray(int[] array, int number) 
      {
          for(int i=0; i<array.length; i++)
           {
                if(number == array[i])
                   return true;
           }
          return false;
      }