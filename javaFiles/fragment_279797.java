public int getLargest()
    {

       for (int i = 0; i < array.length; i++)
       {       

           if (array[i] > largest)
           { 
              largest = array[i];
           }
       }
       return largest;
    }


    public int getSecondLargest()
    {
       for (int i = 0; i < array.length; i++)
       {          
           if  (array[i] < largest)
           {
               if (array[i] > largest2)
               {
                   largest2 = array[i];
                } 
            }

        }
        return largest2;   
    }