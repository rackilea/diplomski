List<LocalDate> dates = Arrays.asList(null, null,
        LocalDate.now(), LocalDate.now().minusDays(9));

LocalDate max = dates.stream()
        .reduce(LocalDate.MIN,
                BinaryOperator.maxBy(Comparator.nullsLast(Comparator.naturalOrder())));
System.out.println(max);