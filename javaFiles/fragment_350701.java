Pair<List<A>, List<Integer>> p2 = p.stream()
            .collect(
                    () -> new Pair<>(
                            new ArrayList<>(),
                            new ArrayList<>()
                    ),
                    (pairOfLists, pair) -> {
                        pairOfLists.getKey().add(pair.getKey());
                        pairOfLists.getValue().add(pair.getValue());
                    },
                    (pairOfLists1, pairOfLists2) -> {
                        pairOfLists1.getKey().addAll(pairOfLists2.getKey());
                        pairOfLists1.getValue().addAll(pairOfLists2.getValue());
                    }
            );