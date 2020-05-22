class Callback{
    abstract void saveOrUpdate(boolean wasInMap);    
}

public void parse(Map<Integer, String> map) {
    for (int j = 0; j < 100; j++) {    
        String obj = "test";

        Callback callback = (wasInMap) -> { //Java 8 syntax to be short
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

        Object returnedValue = map.putIfAbsent(j, callback);

        callback.saveOrUpdate(returnedValue != null);
    }
}