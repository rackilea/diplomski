List<Map<String, Object>> migrationMap = new LinkedList<Map<String, Object>>();
for(Map m: migrationMap){ // For every element in the list
    for(Object v: m.values()){ // For every value that is stored in this list element’s map
        System.out.println(v.toString()); // Print that value
    }
}