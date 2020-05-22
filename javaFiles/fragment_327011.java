static int readArray(int [] fgm, int [] fga, int count, Scanner inFile)
{
    double temp = inFile.nextDouble();
    int k;
    int v;
    v = inFile.nextInt();
    for(k = 0; (v!=-999) && (k<count); k++)
    {
        fgm[k] = v;
        v=inFile.nextInt();
    }
    return k;
}