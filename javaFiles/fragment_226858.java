else if (((word1==word2) && (word1==word3)) && ((word2==word3)&&(word2==word1))) 
    {
        outputString = outputString +"\n\nYour have won $"+(3*userAmountEntered);
        amountWon = (3*userAmountEntered);  
        totalAmountWon += amountWon;
    }