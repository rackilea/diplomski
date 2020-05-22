for (int x = 0; x < word.length(); x++) 
    {
        if (x == i) 
        {
             chararray[x] = word.charAt(j);
        }
        else if (x == j)
        {
            chararray[x] = word.charAt(i);
        }
    }