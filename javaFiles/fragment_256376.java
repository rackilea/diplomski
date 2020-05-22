private int parseInt(char[] c)
{
    int parsed = 0;
    for (i=0 ; i < c.length; i++)
        parsed += Math.pow(10,i) * (c[i]-'0');
    return parsed;
}