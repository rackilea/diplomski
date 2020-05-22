List<Pair<A, B>> pairs = // list of Pait
  Pair<List<A>,List<B>> pairOfLists = pairs.stream()
            .collect(
                    Collector.of(
                            //init accumulator
                            () -> new Pair<>(
                                     new ArrayList<>(),
                                     new ArrayList<>()
                            ), 
                            //processing each element
                            (pairOfLists, pair) -> {
                                pairOfLists.getKey().add(pair.getKey());
                                pairOfLists.getValue().add(pair.getValue());
                            },
                            //confluence of two accumulators in parallel execution
                            (pairOfLists1, pairOfLists2) ->{
                                pairOfLists1.getKey().addAll(pairOfLists2.getKey());
                                pairOfLists1.getValue()addAll(pairOfLists2.getValue());
                                return pairOfLists1;
                            }
                    )
            );