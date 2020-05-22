IntStream.range(0, list.size())
        .boxed()
        .collect(partitioningBy(
                i -> i % 2 == 0, 
                mapping(list::get, toList())
        ));