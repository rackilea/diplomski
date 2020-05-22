float[] avg = new float[5];

for(int i=0 ; i < 5 ; i++)
{
    float sum = 0;
    for(int j=0 ; j < 4 ; j++)
    {
        sum  += datArray[i][j];
    }
    avg[i] = sum/4;
}