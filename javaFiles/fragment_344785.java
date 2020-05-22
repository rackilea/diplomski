private static void getAllCombinations(Map<Integer, Map<String, String>> mapItems,
                              Map<String, String> tempMap, 
                              List<IdData> data, int index)
{
    if (index == data.size())
    {
        mapItems.put(mapItems.size(), new LinkedHashMap<>(tempMap));
        return;
    }

    IdData item = data.get(index);
    String key = item.id;
    for (String value : item.values)
    {
        tempMap.put(key, value);
        getAllCombinations(mapItems, tempMap, data, index + 1);
    }
}