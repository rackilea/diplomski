Person person1 = new Person();
person1.setId("1");

Person person2 = new Person();
person2.setId("1"); //i.e. same as person1

Person person3 = new Person();
person3.setId("2");

Map<String, Person> personMap = new HashMap<>();
personMap.put(person1.getId(), person1);
personMap.put(person2.getId(), person2);
personMap.put(person3.getId(), person3);