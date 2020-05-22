public int[] getMissed()
{
    int k = 0;
    for (int i = 0; i < stuAnswer.length; i++)
    {
        if (stuAnswer[i] != answer[i])
        {
            missed[k] = i;
            k++;
        }
    }
    if(k < missed.length)
    {
      missed[k] = -1
    }
    return missed;
}