public String toString()
{
    StringBuilder s = new StringBuilder();

    s.append(this.coefficient);
    for (int i = 0; i < 26; i++)
    {
        if (degrees[i] == 1)
        {
            s.append(variables[i]);
        }
        else if (degrees[i] > 1)
        {
            s.append(variables[i]).append('^').append(degrees[i]);
        }
    }

    return s.toString();
}