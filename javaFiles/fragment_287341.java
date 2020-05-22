public void getMN(int[] a)
{
    int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
    for(int i=1; i<a.length; i++)
    {
        if(a[i]<a[i-1])
        {
            if(a[i-1] > max)
            {
                max = a[i-1];
            }
            if(a[i] < min)
            {
                min = a[i];
            }
        }
    }
    if(max == Integer.MIN_VALUE){System.out.println("Array already sorted!!!");}
    int m =-1, n =-1;
    for(int i=0; i<a.length; i++)
    {
        if(a[i]<=min)
        {
            m++;
        }
        else
        {
            m++;
            break;
        }
    }
    for(int i=a.length-1; i>=0; i--)
    {
        if(a[i]>=max)
        {
            n++;
        }
        else
        {
            n++;
            break;
        }
    }
    System.out.println(m +" : "+(a.length-1-n));
    System.out.println(min +" : "+max);
}