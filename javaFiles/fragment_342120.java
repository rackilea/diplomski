public static List<String> mapAndMerge(List<String> input,
        List<Grouping> groupingList) {

      Set<String> returnDocs = input
        .stream()
        .map(t -> groupingList
            .stream()
            .filter(g -> g.getName().equals(t))
            .map(v -> v.getList())
            .findAny()
            .orElse(Arrays.asList(t)))
        .flatMap(t -> t.stream())
        .collect(Collectors.toSet());

      return new ArrayList<>(returnDocs);
    }