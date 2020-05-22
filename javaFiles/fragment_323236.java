public String time_to_string(long t) // time in milliseconds
{
    if (t < 0)
    {
        return "-";
    }
    else
    {
        int secs = (int)(t/1000);
        int mins = secs/60;
        secs = secs - (mins * 60);
        return String.format("%d:%02d", mins, secs);
    }
}