Map<String, Integer> map = (Map) document.get("Fruits");
    Iterator iterator = map.keySet().iterator();
    String inventory = " ";
    while(iterator.hasNext()) {
        String key = iterator.next().toString();
        int value = map.get(key);
        inventory += value + " " + key;
        if (iterator.hasNext()) {
            inventory += ", ";
        } else {
            inventory += ".";
        }
    }