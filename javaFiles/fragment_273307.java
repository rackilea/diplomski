static long [] solveEquationB (int x, int j) 
{  
    long[] e = null;
    if (j >= 0) { // or perhaps > 0 if you don't want to return an empty array
        e = new long[j];
        for (int i = 1; i < j; i++)
        {
            x = 1.0*x/(2.0) + 3 ;
            e[i] = x;
        }
    }
    return e;
}