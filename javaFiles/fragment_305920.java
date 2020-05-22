IntStream.range(1, 100)
        .mapToObj(i -> Stream.of(
                    divisibleByThreeAndFiveAndFour,
                    divisibleByThreeAndFour,
                    divisibleByThreeAndFive,
                    divisibleByFive,
                    divisibleByFour,
                    divisibleByThree)
                .filter(p -> p.predicate.test(i))
                .findFirst()
                .map(p -> p.name)
                .orElse("none"))
        .forEach(System.out::println);