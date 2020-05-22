ArrayList<String> departmentList;
    if(test.containsKey(key)){
        // if the key has already been used, then and add a new value to it
        list = test.get(key);
        list.add(value);
        test.put(key, list);
    } else {
        // if the key hasn't been used yet, then create a new ArrayList<String> object, add the value
        list = new ArrayList<String>();
        list.add(value);
        test.put(key, list);
    }