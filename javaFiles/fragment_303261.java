List<CollectivePerson> collectivePersons = persons.stream()
    .map(p -> {
        CollectivePerson cp = new CollectivePerson(p.getId());
        cp.getAddresses().add(p.getAddress());
        cp.getPhones().add(p.getPhone());
        return cp;
    })
    .collect(Collectors.collectingAndThen(Collectors.toMap(
        CollectivePerson::getId, Function.identity(),
        (cp1, cp2) -> {
            cp1.getAddresses().addAll(cp2.getAddresses());
            cp1.getPhones().addAll(cp2.getPhones());
            return cp1;
        }),
      m -> new ArrayList<>(m.values())
    ));