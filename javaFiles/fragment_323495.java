//The three numbers should be entered by a user in the main method. 

MAIN PROGRAM starts 
declare a , b , c as numbers

//The numbers should be positive and less than 200. 
// see validNumCheck below.

//part 1.If not, the program asks the user to renter the number.
//part 2.The user will have three chances to enter a valid number for each number. 
//part 3. If the number is still invalid after the three trials, the program displays an error message to the user and ends.

 // ok then read a number and validate it. 
 attempts = 0;
 maxAttempts = 3;

 //part 2. three chances... .           
 loop_while (  attemtps < maxAttempts ) do  // or 3 directly.

      number = readUserInput();  // part 1. reenter the number...
      if( numcheck( number ) == false ) then 
           attempts = attempts + 1;
           // one failure.. try again. 
      else 
           break the loop.
      end 

 end 

 // part 3:. out of the loop. 
 // either because the attempts where exhausted 
 // or because the user input was correct.  
 if( attempts == maxAttemtps ) then 
     displayError("The input is invalid due to ... ")
     die();
 else  
     a = number 
 end 

// Now I have to repeat this for the other two numbers, b and c.
// see the notes below... 
MAIN PROGRAM ENDS