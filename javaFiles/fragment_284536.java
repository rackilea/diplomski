Random generator = new Random();
    Set<Integer> interact = new HashSet<Integer>();
    int numberOfItems = generator.nextInt(5) + 3;
    while (interact.size() < numberOfItems) {
        interact.add(generator.nextInt(10));
    }