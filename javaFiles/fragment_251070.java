public static Map<String, Map<String, String>> convertToStringToHashMap(String text)
{
    Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();

    Pattern p = Pattern.compile("[\\{\\}\\=\\, ]++");
    String[] split = p.split(text);

    Map<String, String> data = new HashMap<String, String>();
    int gap = 8;
    int key = 1;

    for (int i = 1; i + 2 <= split.length; i += 2)
    {
        data.put(split[i], split[i+1]);
        if((i + 1) % gap == 0)
        {
            map.put(String.valueOf(key++), data);
            data = new HashMap<String, String>();
            data.clear();
        }
    }

    return map;
}