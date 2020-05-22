PersonMapper personMapper = ...;
try (Cursor<Person> persons = personMapper.selectAllPersons()) {
   for (Person person : persons) {
      // process one person
   }
}