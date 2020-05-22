IntStream.rangeClosed(0, 100)
    .forEach(i -> {
       Person person=new Person();
       person.setId(i);
       person.setName("name"+i);
       list.add(person);
     });