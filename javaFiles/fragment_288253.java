for(Map m: migrationMap){ // For every element in the list
    Set<String> keys = m.keySet(); // Get a set of all keys in the map
    for(key: keys){ // For every key in said set
        Object value = m.get(key); // Retrieve the object referenced by this key
        System.out.println(m.get(key)); // Print it
    }
}