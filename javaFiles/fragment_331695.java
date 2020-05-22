private static Map<String, String> parseArgs(String... pArgs)
  {
    if (pArgs == null) return null;

    Map<String, String> map = new HashMap<String, String>();
    String arg;
    String key;
    String value;
    for (int i = 0, iLength = pArgs.length; i < iLength; i += 2)
    {
      arg = pArgs[i];

      // GET KEY
      if (!arg.startsWith("-")) continue;
      key = arg.substring(1);

      // GET VALUE
      if ((i + 1) >= pArgs.length) break;
      value = pArgs[i + 1];

      // PUT IT IN MAP
      map.put(key, value);
    }
    return (map.isEmpty()) ? null : map;
  }