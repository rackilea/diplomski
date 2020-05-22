City city = new City(1);
session.save(city);

Street street = new Street(2);
session.save(street);

Peron p = new Person(city, street);
session.save(p);

session.flush();