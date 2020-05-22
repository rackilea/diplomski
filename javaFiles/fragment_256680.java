while(guess != num){  //while guess is not = to number  
      if(guess < num){             //if less than num
        System.out.println("Your guess is too low"); 
        System.out.println("Guess the random number. The number is between 1 and 100. Enter it below");
        guess = console.nextInt();
        count++;
      }else{      //if greater than num   
          System.out.println("Your guess is too high");
          System.out.println("Guess the random number. The number is between 1 and 100. Enter it below");
          guess = console.nextInt();
          count++;
      }
    }

  System.out.println("You guessed correctly after " + ++count + " tries!");