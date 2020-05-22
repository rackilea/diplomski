for(int n = 0; n < trials; n++)
{
    hits=0;
    for(int i = 0; i < darts; i++)
    {
        xInt[i] = (Math.random() * (upper - lower)) + lower;
        yInt[i] = (Math.random() * (upper - lower)) + lower;
        c2[i] = Math.pow(xInt[i], 2) + Math.pow(yInt[i], 2);
        c[i] = Math.sqrt(c2[i]);  
        if(c[i] <= 1)
            hits++;
    }
    double answer = 4 * ((double)hits / (double)darts);            
    System.out.println(answer);
}