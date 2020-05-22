public void rearrange()
   {

      int[] nums = new int[10];

      int holder;

      Random r = new Random();

      boolean doesItMatch = true;

      holder = r.nextInt(10);

      for(int j = 0; j < 10; j++)
      {

         nums[j] = 10;

      }

      //^^This for loop is just to give them a value to start with so they won't be null. 
      //I assume the buttons will already have values by the time it's time to scramble

      for(int i = 0; i < 10; i++)
      {

         do
         {

            doesItMatch = false;

            for(int k = 0; k < 10; k++)
            {

               if(nums[k] == holder)
               {

                  doesItMatch = true;
                  holder = r.nextInt(10);
                  k = 10;

               }

            }

         }while(doesItMatch);

         nums[i] = holder;
         r.nextInt(10);

      }

   }