for(num = lowerEnd; num <= upperEnd; num++)
    {
        int nNum = num;
        while (nNum > 0)
        {
            if( (nNum % 10) == 3)
                count = count + 1;
            nNum = nNum / 10;
        }
    }