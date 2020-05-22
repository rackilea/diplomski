f1 = stdin.readLine();
    int guess = Integer.parseInt(f1); 

    while(guess != number)
    {
        if(guess < number)
        {
            System.out.println("Higher. Please Guess Again...\n");
        }
        else if(guess > number)
        {
            System.out.println("Lower. Please Guess Again...\n");
        }

        f1 = stdin.readLine();
        guess = Integer.parseInt(f1); 
    }