for (int i = 0; i < c.length; i++) //In an array, length is a property, not a function
{
    if (longest < c[i].length())
    {
        longest = c[i].length();
        word = c[i];
    }
}