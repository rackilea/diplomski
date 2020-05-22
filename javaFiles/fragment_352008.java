List<Person> allPeople; // your list of all people
Map<String, List<Person>> map = new HashMap<String, List<Person>>();
for (Person person : allPeople) {
   String key = person.getName();
   if (map.get(key) == null) {
      map.put(key, new ArrayList<Person>());
   }
   map.get(key).add(person);
}

List<Person> davids = map.get("David");