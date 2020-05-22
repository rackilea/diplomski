public static int addHours(int hours, int hrs)
    {
        int newHours = hours + hrs;
        if (newHours > 24)
        {
            return newHours % 24;
        }
        else
        {
            return newHours;
        }
    }