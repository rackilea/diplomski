public static long Climb(long height, long time, bool justrested)
    {
        //Recursive method
        if (height <= 0)
        {
            //base case
            return time;
        }

        if(time%10 == 0 && !justrested)
        {
            return Climb(height + 3, time + 10, true);
        }

        return Climb(height - 1, time + 1, false);
    }