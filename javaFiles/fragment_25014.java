static string ListAsString(List<double> input)
{
    var sb = new StringBuilder();
    for (int i = 0; i < input.Count; )
    {
        var value = input[i];
        int count = 1;
        while (++i < input.Count && input[i] == value)
            count++;
        if (sb.Length > 0) sb.Append(' ');
        if (count > 1) sb.Append(count).Append('*');
        sb.Append(value);
    }
    return sb.ToString();
}