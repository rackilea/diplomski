// static instance uses default alias "person"
QPerson person = QPerson.person;
QPerson neighbor = new QPerson("neighbor");

JPAQuery query = new JPAQuery(em)
    .from(person, neighbor)
    .where(person.adress.eq(neighbor.adress))
    .groupBy(person.name);