Map<String, ArrayList<String>> nameGameListMap= new HashMap<String, ArrayList<String>>();
    Iterator<String> it = name.keySet().iterator();
    while(it.hasNext())
    {
        String name = it.next();
        String city = name.get(name);
        if(games.containsKey(city))
        {
            nameGameListMap.put(name, games.get(city));
        }
    }