Map<String, Optional<Movie>> map = ml.getDataAsStream()
    .<ImmutablePair<String, Movie>>flatMap(x -> x.getGenre()
            .map(g -> new ImmutablePair<String, Movie>(g, x)))
    .collect(
            Collectors.groupingBy(
                ImmutablePair::getLeft,
                Collectors.mapping(ImmutablePair::getRight, 
                    Collectors.maxBy(Comparator.comparing(Movie::getVoteCount)))
            ));