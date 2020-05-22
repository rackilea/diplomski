HashMap<Character,Integer> map = new HashMap<Character,Integer>();

    //iterate over your chars
    for(char c : myString.toCharArray())
    {
        Character character = new Character(c);
        if(map.containsKey(character))
        {
            map.put(character, new Integer(map.get(character).intValue()+1));
        }else
        {
            map.put(character, new Integer(1));
        }
    }