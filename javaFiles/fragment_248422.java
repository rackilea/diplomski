// 0 to 5-1 boxed so we can flatMap IntStream to Stream<String> later.
IntStream.range(0, 5).boxed()
        // generate pairs of ?::n and n::? or only one if the same.
        .flatMap(n -> IntStream.rangeClosed(0, n).boxed()
                 // generate the pair, dropping duplicates.
                 .flatMap(m -> Stream.of(m + ":" + n, n + ":" + m).distinct())
        // print the results.
        ).forEach(System.out::println);