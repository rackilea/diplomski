Map<Integer, List<Integer>> map =
        list.stream()
            .collect(Collectors.toMap(
                Collection::size,
                x -> x.stream().filter(y -> y % 2 == 0).collect(Collectors.toList())
            ));