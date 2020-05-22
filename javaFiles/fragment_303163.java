// scale from percents to a number between 0-255
private int scale(int percents)
{
    return (percents * 255) / 100;
}

private int getColorForPercents(int percents)
{
    int red = scale(percents);
    int blue = scale(100 - percents);
    return 0xff000000 | (red << 16) | (blue);
}