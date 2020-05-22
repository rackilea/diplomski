doInJPA( entityManager -> {

    Person person1 = new Person();
    person1.id = "abc1";
    entityManager.persist(person1);

    Person person2 = new Person();
    person2.id = "abc2";
    entityManager.persist(person2);

    Group group = new Group();
    group.id = "g1";
    entityManager.persist(group);

    GroupAssociationEntity p1g1 = new GroupAssociationEntity();
    p1g1.id = new GroupAssociationKey("G1", "ABC1");
    p1g1.group = group;
    p1g1.person = person1;
    entityManager.persist(p1g1);

    GroupAssociationEntity p2g1 = new GroupAssociationEntity();
    p2g1.id = new GroupAssociationKey( "G1", "ABC2" );
    p2g1.group = group;
    p2g1.person = person2;
    entityManager.persist(p2g1);
} );

doInJPA( entityManager -> {
    Group group = entityManager.find(Group.class, "g1");
    assertEquals(2, group.persons.size());
} );

doInJPA( entityManager -> {
    Person person = entityManager.find(Person.class, "abc1");
    assertEquals(1, person.groups.size());
} );