public List<Person> rank(List<Person> people) {
        return people
                .stream()
                .sorted(Comparator.<Person>comparingDouble(x -> x.profit).reversed())
                .collect(new IntegerRankingCollector<>(
                        Comparator.comparingDouble(p -> p.profit),  // how to differentiate rankings
                        p -> p.rank,    // where to get rank for an element which was already ranked
                        (p, rank) -> new Person(rank, p.profit)     // how to create an element from another element values and a rank
                ));
    }