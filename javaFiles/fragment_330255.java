Map<String, Optional<POJO>> map = Stream.of(
            new POJO("A", 1), new POJO("A", 2), new POJO("A", 10),
            new POJO("B", 8), new POJO("B", 4),
            new POJO("C", 4),
            new POJO("D", 4), new POJO("D", 1), new POJO("D", 2)
            ).collect(
                    Collectors.groupingBy(
                            POJO::getName, 
                            Collectors.maxBy(
                                    Comparator.comparingInt(POJO::getValue)
                            )
                    )
            );

    System.out.println(map);