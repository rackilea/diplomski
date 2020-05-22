public long[] possibleValues(int n)
{
    long[] solutionSet = new long[n*n*n];

    int c = 0;
    for(int i = 1; i <= n; i++)
    for(int j = i; j <= n; j++)
    for(int k = j; k <= n; k++)
    {
        solutionSet[c] = ((long) Math.pow(i, 5) + (long) Math.pow(j, 5) + (long) Math.pow(k, 5));

       //testing purposes
        System.out.println(i +"^5 " + "+" + j+"^5 " + "+" + k+"^5" + "=" + solutionSet[c]);
        c++;
    }

    return solutionSet;
}