if (args.BasicProperties.Headers.TryGetValue("client_properties", out object value))
{
    var items = value as List<object>;
    foreach (var item in items)
    {
        var bytes = item as byte[];
        //{<<id>>, type, <<value>>}
        String itemStr = Encoding.UTF8.GetString(bytes);
        var parts = itemStr.Split(",");
        var key = CleanErlangString(parts[0]);
        var value = CleanErlangString(parts[2]);

        // Do things with key/value

    }
}