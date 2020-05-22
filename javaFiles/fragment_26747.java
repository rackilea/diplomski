List<Person> persons = IntStream.rangeClosed(0, 100)
    .mapToObj(i -> {
       Person person=new Person();
       person.setId(i);
       person.setName("name" + i);
       return person;
      })
      .collect(Collectors.toList());