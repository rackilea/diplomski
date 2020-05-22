public static Date fromDotNetTicks(long ticks)
{
    // Rebase to Jan 1st 1970, the Unix epoch
    ticks -= 621355968000000000L;
    long millis = ticks / 10000;
    return new Date(millis);
}