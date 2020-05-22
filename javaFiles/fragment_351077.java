public long[][][] possibleValues(int n)
{
    long[][][] solutionSet = new long[n+1][n+1][n+1];

    for(int i=1;i<=n;i++)
    for(int j=1;j<=n;j++)
    for(int k=1;k<=n;k++)
    {
        solutionSet[i][j][k] = ((long) Math.pow(i, 5) + (long) Math.pow(j, 5) + (long) Math.pow(k, 5));

       //testing purposes
        System.out.println(i +"^5 " + "+" + j+"^5 " + "+" + k+"^5" + "=" + solutionSet[i][j][k]);
    }

    return solutionSet;
}