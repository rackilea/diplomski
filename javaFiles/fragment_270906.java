public void put(String string) {
    if (map.containsKey(string)) {
        // anything can happen in another thread here
        List<String> li = map.get(string);
        // anything can happen in another thread here
        li.add("adding something");
    } else {
        // anything can happen in another thread here
        List<String> li = new ArrayList<String>();
        li.add("adding something");
        // anything can happen in another thread here
        map.put(string, li);
    }