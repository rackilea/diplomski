boolean test = true;
do{
   //your code
   //if you want to break you can change the test variable
   ...
     if(val.equalsIgnoreCase("n")){ 
         System.out.println(THANKS_MSG);
         test = false;
         break();
     } 
   ..
}while(guess > MIN_NUMBER || guess < MAX_NUMBER || test);