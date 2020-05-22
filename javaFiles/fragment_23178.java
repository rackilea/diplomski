class Pair<T, U> {
        public final T x;
        public final U y;

        public Pair(T x, U y) {
            this.x = x;
            this.y = y;
        }
    }

    Collector<Aggregate, ?, Pair<Integer, Integer>> aggregateSalary = 
        mapping(a -> new Pair<>(a.getMinSalary(), a.getMaxSalary()),
            reducing(new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE),
                (a, b) -> new Pair<>(Math.min(a.x, b.x), Math.max(a.y, b.y))));

    Map<String, Pair<Integer, Integer>> byDepartmentMinMax =
        deptTeamAggregates.stream()
            .collect(groupingBy(a -> a.getDepartment(), aggregateSalary));

    Map<Pair<String, String>, Pair<Integer, Integer>> byDepartmentAndTeamMinMax =
        deptTeamAggregates.stream()
            .collect(toMap(a -> new Pair<>(a.getDepartment(), a.getTeam()), a -> new Pair<>(a.getMinSalary(), a.getMaxSalary())));