private static long findMax(string series, int howMany)
{
    var numbers = series.Select(c => int.Parse(c.ToString())).ToArray();

    var highest = 0L;

    for (int i = 0; i < numbers.Count() - howMany; i++)
    {
        var result = 1L;
        for (int j = i; j < i + howMany; j++)
        {
            result *= numbers[j];
        }

        if (result > highest)
            highest = result;
    }

    return highest;
}