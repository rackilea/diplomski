Map<String, List<Preference>> map = 
    new LinkedHashMap<String, List<TestDrive.Preference>>();
for(Preference e : prefs) {
    List<Preference> list = map.get(e.getType());
    if(list == null) {
        list = new ArrayList<TestDrive.Preference>();
        map.put(e.getType(), list);
    }
    list.add(e);
}

for(Entry<String, List<Preference>> l : map.entrySet()) {
    System.out.println(l.getKey() + " " + l.getValue());
}