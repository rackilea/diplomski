final Person p3 = Person.of(
    p.name(),
    Address.of(
       p.house(), p.street(), "Berlin", p.country()
    ),
    p.x(),
    p.y(),
    p.z()
 );