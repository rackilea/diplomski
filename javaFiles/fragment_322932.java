public int HW2C( int [ ]recordings ) {
     int temp = 45;
     int counter = 0 ; 
     for(int i = 0; i < recordings.length; i++) //i++ is more meaningful here
       { 
         if (recordings[i] >= temp)
           {
              counter++;
              recordings[i]=32;
             //If you increment i here and condition failed, then you will end up with infinite looping
           }
       }

     return counter;  //This will execute after executing entire for loop
   }