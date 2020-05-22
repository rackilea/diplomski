int result = Stream.of(1)
            .flatMap(x -> Stream.generate(() -> ThreadLocalRandom.current().nextInt()))
            .findFirst()
            .get();

    System.out.println(result);