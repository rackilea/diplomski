for(int i = 0; i<lst.size()-1; i++) 
    // checking whether pair already exists
    if(map.containsKey(lst.get(i)+lst.get(i+1))) 
        map.put(lst.get(i)+lst.get(i+1), map.get(lst.get(i)+lst.get(i+1))+1); // if yes increment the current value by one
    else 
        // else add the new key with value 1
        map.put(lst.get(i)+lst.get(i+1), 1);