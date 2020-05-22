List l = new ArrayList();
    l.add("A");
    l.add(null);
    l.add("B");
    l.add(null);
    l.add("C");

    System.out.println(l); // Outputs [A, null, B, null, C]

    CollectionUtils.filter(l, PredicateUtils.notNullPredicate());

    System.out.println(l); // Outputs [A, B, C]