HashMap<Integer,Integer> getRoots(int x)
{

    HashMap<Integer,Integer> retval = new HashMap<Integer,Integer>();
    int i=2;

    while(i<=x)
    {
        int power = 0;

        while( x%i == 0)
        {
            power++;
            x /= i;
        }

        if(power>0)
        {
            retval.put(i,power);
        }

        if(x==1)
        {
            break;
        }

        i++;
    }

    return retval; 
}