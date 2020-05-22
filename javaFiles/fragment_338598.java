Map<String, Person> map = new HashMap<String, Person>();
Person p = new Person("John", "1234");
map.put(p.getName().toLowerCase(), p);

// loopup
Person john = map.get("John".toLowerCase());