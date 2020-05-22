Person person1 = new Person("Edward", 1, 20);
Person person2 = new Person("Krzych", 1, 6);
Person person3 = new Person("Edward", 1, 13.5);
Person person4 = new Person("Grzesiek", 2, 50);
Person person5 = new Person("Edward", 2, 12);

ArrayList<Person> arrList = new ArrayList<>();

arrList.add(person1);
arrList.add(person2);
arrList.add(person3);
arrList.add(person4);
arrList.add(person5);

Map<Person, Double> result = arrList.stream().collect(Collectors.groupingBy(x -> x, Collectors.summingDouble(Person::getWorkTime)));