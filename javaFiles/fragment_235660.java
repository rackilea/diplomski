List<Person> result4 =
    persons.stream()
           .filter(x -> dummyRequest.getSurname() == null || dummyRequest.getSurname().equals(x.getSurname()))
           .filter(x -> dummyRequest.getName() == null || dummyRequest.getName().equals(x.getName()))
           .filter(x -> dummyRequest.getCountry() == null || dummyRequest.getCountry().equals(x.getCountry()))
           .collect(Collectors.toList());