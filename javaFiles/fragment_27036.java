// These two lines of code are no longer required.
    //System.out.printf("Enter the word of the day:  ");
    //wordOfTheDay = input.nextLine();

    do
    {
        System.out.printf("Enter the word of the day:  ");
        wordOfTheDay = input.nextLine();

        if(!wordOfTheDay.equals("tired"))
        {
            System.out.printf(
                "Invalid! Try Again! %d attempt(s) left!\n ", --attempt);
        }
        else
        {
            attempt = 0; // Another ugly 'break'
        }
    } while (attempt >= 1);


    if(wordOfTheDay.equals("tired"))
    {
    }
    // Remove else branch as not required.