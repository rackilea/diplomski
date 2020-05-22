TreeSet<x> ts = new TreeSet<>();
ts.add(new x(3, true));
ts.add(new x(1, true));
ts.add(new x(2, true));
ts.add(new x(5, true));
ts.add(new x(4, true));
Iterator<x> iterator = setOfX.iterator();
    while (iterator.hasNext()) {
        // Call iterator.next() only once per iteration
        x value = iterator.next();

        System.out.println("ID:"+value);
        Iterator<x> innerIterator = setOfX.tailSet(value, true).iterator();
        while (innerIterator.hasNext()) {
            int id = innerIterator.next().id;
            System.out.println(id);
        }
    }