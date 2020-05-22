public static int mode(int[] v)
{
    int modeCount = 0,mode = 0, currCount = 0;
    boolean thereIsMode = false;
    boolean ModeIsRepeated = false;

    for (int candidateMode : v)
    {
        if(candidateMode == mode)
            continue;

        currCount = 0;

        for (int element : v)
        {
            if (candidateMode == element)
            {
                currCount++;
            }
        }

        if (currCount > modeCount)
        {
            modeCount = currCount;
            mode = candidateMode;
            thereIsMode = true;
            ModeIsRepeated = false;
        }
        else if( currCount == modeCount && candidateMode != mode )
        {
            ModeIsRepeated = true;
        }
    } 

    if( !thereIsMode || ModeIsRepeated ){
        return -1;
    }

    return mode;
}