int numberCount = 0;
    for (int i = 0; i < numberCharaters; i++)
    {
        for(char c = '0'; c <= '9'; c++)
        {
            if (passwordInput.charAt(i) == c)
            {
                    numberCount++;
            }       
        }
    }