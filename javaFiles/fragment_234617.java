reducedPerson = Person.getPersons().parallelStream()
        .collect(
                Person::new,
                (p, q) -> p.setAge(p.getAge() + q.getAge()),
                (p, q) -> p.setAge(p.getAge() + q.getAge())
        );