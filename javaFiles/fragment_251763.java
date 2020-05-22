private static void Main()
{
    Dictionary<string, string> tmp = new Dictionary<string, string>
    {
        {"0:10", ""},
        {"10:12+", ""},
        {"2:10", ""},
        {"1:10", ""},
        {"10:1", ""}
    };

    var javaSorted = tmp.OrderBy(item => item.Key, StringComparer.Ordinal)
        .ToDictionary(i => i.Key, i => i.Value);

    Console.WriteLine(string.Join(", ", javaSorted.Select(item => item.Key)));

    GetKeyFromUser("\nDone! Press any key to exit...");
}