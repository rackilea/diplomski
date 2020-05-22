for(int i=0; i<n; i++)
{
    for(int j=0; j<n; j++)
    {
        final double[] v1 = matrix1[i];
        final double[] v2 = matrix2[j];
        result[i][j] = exe.submit(() -> vecdot(v1,v2));
    }
}