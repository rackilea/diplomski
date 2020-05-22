Map<String, Integer> map = new HashMap<String, Integer>();
    for(int i = 0;i<list.size(); i++)
    {
        URL url = new URL(list[i]);
        if (map.containsKey(url.getHost()))
        {
            map.put(url.getHost(), map.get(url.getHost()) + 1);
        }
        else
        {
            map.put(url.getHost(), 1);
        }
    }