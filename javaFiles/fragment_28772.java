int guess;
do {
   System.out.print("\nEnter your guess: ");

   guess = input.nextInt();


   if (guess == number)
       System.out.println("you are correct, the number is " + number);
   else if (guess > number)
       System.out.println("your guess is too high");
   else
       System.out.println("your guess is too low");
}while(guess != number);