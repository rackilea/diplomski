Set<String> set = map.get(person1);
if (set == null) {
    set = new TreeSet<String>();
    map.put(person1, set);
}
set.add(person2);