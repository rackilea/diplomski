// display the high score
    if (points > highScore)
    {    
        System.out.println("You now have the new high score! The previous high score was " + highScore);
    } else if (points == highScore) {
        System.out.println("You tied the high score!");
    } else {
        System.out.println("The all time high score was " + highScore);
    }