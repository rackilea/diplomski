for(int i = 0; i<lst2.size()-1; i++) 
    // Checking for existing key in same map thus will increment any key matching that of lst keys or any in current lst2
    if(map.containsKey(lst2.get(i)+lst2.get(i+1)))
        map.put(lst2.get(i)+lst2.get(i+1), map.get(lst2.get(i)+lst2.get(i+1))+1);
    else
        map.put(lst2.get(i)+lst2.get(i+1), 1);