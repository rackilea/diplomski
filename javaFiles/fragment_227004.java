public static int user_hand(int number_of_hits)
{   
     int user_total=0;
     int user_card=generate_a_card();
     System.out.println( "you drew: " + user_card );
     int user_current_hand [] = new int [number_of_hits];

     for (int i=0; i<user_current_hand.length; i++)
     {
          user_current_hand [i]= user_card;
          System.out.println( user_card + " has been stored in index " + i + " of 
                user_current_hand array");


           for(int j=0; j<user_current_hand.length; j++)
              {
           user_total+= user_current_hand[i];

             if (user_total>21)
            {
                System.out.println("you have exeeded 21, you lose!");
             }//if end
       }//nested for loop

    }//first for loop


   return user_total;