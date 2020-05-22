List<String> order = Arrays.asList("MATH", "ENGLISH", "SCIENCE");

    classes.stream().sorted(
            comparing(ClassRoom::getPeriod)
                    .thenComparingInt(c -> order.indexOf(c.getCourseName())))
            .forEach(System.out::println);