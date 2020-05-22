Stream<String> stream1 = Stream.of("w", "o", "l", "f");
    String word = stream1.collect(
            String::new,
            (left, right) -> {
                left.concat(right); // result is ignored
            },
            String::concat);