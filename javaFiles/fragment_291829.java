cars.add(c1);
cars.add(c2);

c1.setPerson(p);
c2.setPerson(p);

p.setCars(cars);
personJpaRepository.save(p);