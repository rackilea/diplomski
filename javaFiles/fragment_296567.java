// remove old key
    List<String> oldValue = map.remove(oldKey);
    // add new key with empty list if not exists
    if(!map.containsKey(newKey))
    {
        map.put(newKey, new LinkedList<String>());
    }
    // new list for new value
    List<String> newValue = map.get(newKey);
    // add items from old value to new list
    for(String s : oldValue){
        // eliminate possible duplicates
        if(!newValue.contains(s)){
            newValue.add(s);
        }
    }