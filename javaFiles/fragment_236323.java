JavaPairRDD<Integer, List<Integer>> result = rddA
                .flatMapValues(x -> x) // flattening the list
                .mapToPair(x -> x._2) // getting rid of the first key
                .groupByKey()
                .mapValues(x -> { // turning the iterable into a list
                    List<Integer> list = new ArrayList<>();
                    x.forEach(list::add);
                    return list;
                });