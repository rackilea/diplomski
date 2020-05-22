StringBuilder output = new StringBuilder();
// for each input element
{
    while (output.length() < start)
    {
        output.append(' ');
    }
    output.replace(start, end, string);
}