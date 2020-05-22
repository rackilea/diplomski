int count = 0;
    String guessString = Integer.toString(4455);
    String randomValueString = Integer.toString(5509);

    char [] randomValueCharacter = randomValueString.toCharArray();
    char [] guessCharacter = guessString.toCharArray();


    while(guessString.length() < 4)
    {
        guessString = "0" + guessString;
    }

    while(randomValueString.length() < 4)
    {
        randomValueString = "0" + randomValueString;
    }

    for (int i = 0; i < 4; i++)
    {
        if (guessCharacter[i] == randomValueCharacter[i])
        {
            randomValueCharacter[i] = 'X';
            guessCharacter[i] = 'O';
        }
    }

    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (guessCharacter[j] == randomValueCharacter[i])
            {
                count++;
                randomValueCharacter[i] = 'X';
                guessCharacter[j] = 'O';
            }

        }
    }

    return count;
}