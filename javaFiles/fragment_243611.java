int[] digit = new int[3];
while (!nullReached)
{
    for (int i = sampleIndex; i < sampleIndex + 3; i++)
    {
        if (i < samples.length)
        {
            digit[i] = getDecimalDigit(samples[i].getValue(), 0);   // This should be the line that throws the exception                
        }               
    }           
    sampleIndex += 3;           
}