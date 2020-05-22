int i = num + 1;
    while (true)
    {
        int numCheck = 0;
        int r;
        int numAfter = i;
        while (numAfter != 0)
        {
            r = numAfter%10;
            numCheck = numCheck*10+r;
            numAfter = (numAfter-r)/10;
        }
        if (numCheck==i)
        {
            System.out.println("Minumum palindrome number that greater than input number: "+i);
            break;
        }
        i++;
    }