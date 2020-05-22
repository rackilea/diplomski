Collection<CollectivePerson> collectivePersons = persons.stream()
    .collect(
        HashMap<Long,CollectivePerson>::new,
        (m,p) -> {
            CollectivePerson cp=m.computeIfAbsent(p.getId(), CollectivePerson::new);
            cp.getAddresses().add(p.getAddress());
            cp.getPhones().add(p.getPhone());
        },
        (m1,m2) -> m2.forEach((l,cp) -> m1.merge(l, cp, (cp1,cp2) -> {
            cp1.getAddresses().addAll(cp2.getAddresses());
            cp1.getPhones().addAll(cp2.getPhones());
            return cp1;
        }))).values();