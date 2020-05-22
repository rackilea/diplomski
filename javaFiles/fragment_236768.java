//some code omitted if not relevant to your problem
do
{
    if(total == 2)
    {
        computerScore += computerTurn;  //adds current turn to running total
        System.out.println("Turn over.");
        System.out.println("My current score is " + computerScore + "\n");
        turnOver = true;
    }

    else
    {
        computerTurn+= total;
        System.out.println("My current score is " + computerScore + "\n");
        if(computerTurn >= 35) //checks against current turn instead of total
        {
            computerScore += computerTurn; //adds current turn to running total
            System.out.println("I hold.");
            System.out.println("Your turn!\n");
            System.out.println("My current score is " + computerScore + 
                " your score is " + humanScore + "\n");
            turnOver = true;
        }
    }
}while(turnOver == false);
computerTurn = 0;