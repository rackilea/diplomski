IntStream.range(0,  input.length)
                .boxed()
                .flatMap(i -> IntStream.range(0,  input.length).boxed()
                                .map(j -> new Pair(i,j))
                )
                        .filter(p -> p.i != p.j)
                        .filter(p -> input[p.i] + input[p.j] == target)
                        .collect(toList());