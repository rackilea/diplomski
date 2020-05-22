for (int i = num+1; i>num; i++)
    {
        int numCheck = 0;
        int r;
        int numAfter = i;
        while (true)
        {
            r = numAfter%10;
            numCheck = numCheck*10+r;
            numAfter = (numAfter-r)/10;
            if (numAfter==0)
            {
                break;
            }
        }
        if (numCheck==i)
        {
            System.out.println("Minumum palindrome number that greater than input number: "+i);
            break;
        }
    }