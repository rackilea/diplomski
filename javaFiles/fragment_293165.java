public List<Pair<String, Integer>> mergeIdWithGrade(List<String> id, List<Integer> grades) {
      return IntStream
            .range(0, Math.min(id.size(), grades.size()))
            .parallel() // try with and without it
            .mapToObj(i -> new Pair(id.get(i), grades.get(i)))
            .collect(Collectors.toList());
    }