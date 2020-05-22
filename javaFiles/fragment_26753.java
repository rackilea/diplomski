int count =0;
for (i = 1; i <= 100; i++) {

        int counter=0;    

        for( num =i; num>=1; num--)
        {
        if(i % num == 0)
    {
        counter = counter + 1;
            }
        }
        if (counter == 2)
        {
            //Display the output of 5 numbers per row.
          System.out.print(" " + i);
          count++;
          if(count == 5) {
              System.out.print("\n");
              count = 0;
          }
     //Prime number is assigned to the empty string class variable.
     displayPrimes = displayPrimes + i + " ";
        }
   }