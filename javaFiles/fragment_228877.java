String[] direction = { "north", "north", "east", "south", "south",
        "south", "north", "north" };

Map<String, Integer> map = new LinkedHashMap<>();//to preserve order or elements
for (String key : direction) {
    if (map.containsKey(key))
        map.put(key, map.get(key) + 1);
    else
        map.put(key, 1);
}
for (Map.Entry<String, Integer> entry : map.entrySet())
        System.out.println(entry.getKey() + "(" + entry.getValue() + ")"+
                String.format("%"+entry.getValue()+"s", "").replace(' ', '*'));