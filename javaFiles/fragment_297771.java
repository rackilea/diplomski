Map<Integer, List<Person>> myHashMap = new HashMap<>();

for (Person person : persons) {
   int age = person.getAge();
   List<Person> personsOfSameAge = myHashMap.get(age);
   if (personsOfSameAge == null) {
       personsOfSameAge = new ArrayList();
       myHashMap.put(age, personsOfSameAge);
   }          
   personsOfSameAge.add(person);                
}