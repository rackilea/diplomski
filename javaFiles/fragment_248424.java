// numbers 0 to 5-1
IntStream.range(0, 5)
         // make them boxed so we can do a flatMap to a Stream<String> later.
         // IntStream can't flapMap to a stream of Objects. 
         .boxed()
         // create two streams of ?::n and n::?
        .flatMap(n -> Stream.of(
                // stream is 0 .. n-1 to avoid duplicate n with next stream.
                // generate ?::n
                IntStream.range(0, n).mapToObj(m -> m + ":" + n),
                // stream is 0 .. n of n::?
                IntStream.rangeClosed(0, n).mapToObj(m -> n + ":" + m)
        // combine the two streams into one so that stream can be flatMappped.
        ).flatMap(s -> s))
        // print the results.
        .forEach(System.out::println);