putIfAbsent:
    - returns the previous value associated with the specified key, 
      or null if there was no mapping for the key

public void parse(ConcurrentHashMap<Integer, String> map) {
    for (int j = 0; j < 100; j++) {    
        String obj = "test";

        Object returnedValue = map.putIfAbsent(j, obj);

        boolean wasInMap = returnedValue != null;

        if (wasInMap) {
            System.out.println("Update");
            //session.update(map.getKey(j));
        } else {
            System.out.println("add to map " + j);

            map.put(j, obj);
            System.out.println("save");
            //session.save(obj);
        }
    }
}