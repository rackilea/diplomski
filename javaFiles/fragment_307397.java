final static int NUMBER_OF_TRIES = 3;
boolean correctNumber = false;
int attemptNumber = 0;

while (!correctNumber)
{

    //get user input

    if (inputIsCorrect)
    {
        createANewGame();
        correctNumber = true;
    }
    else
    {
        System.out.println("Incorrect answer");
        attemptNumber++;
    }

    if(!inputIsCorrect && attemptNumber == NUMBER_OF_TRIES)
    {
        System.out.println("You have reached the max number of tries");
        System.exit(0);  //or whatever you want to happen
    }

 }