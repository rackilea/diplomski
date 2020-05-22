String maxKey = null;
for (String key : map.keySet())
{
    if (maxKey == null || map.get(key).size() > map.get(maxKey).size())
    {
        maxKey = key;
    }
}