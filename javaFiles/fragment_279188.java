public float findAvg(int a[], int n)
{
    float sum,avg;
    if(n==1)
    {
        sum=a[0];
    }
    else 
    {
        // Calculate sum of n-1 numbers = (n-1) * (avg of n-1 numbers)
        // and add nth number to it ( i.e. a[n-1])
        sum= a[n-1]+ (n-1) * findAvg(a,n-1);
    }
    avg = sum/n;
    return avg;
}