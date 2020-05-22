function giveMeValidUserInput() starts 
    maxAttempts = 3;
    attempts = 0;


     loop_while (  attemtps < maxAttempts ) do  // or 3 directly.

          number = readUserInput();
          if( numcheck( number ) == false ) then 
               attempts = attempts + 1;
               // one failure.. try again. 
          else 
               return number 
          end 

     end 

     // out of the loop. 
    // if we reach this line is because the attempts were exhausted.
     displayError("The input is invalid due to ... ")
   function ends