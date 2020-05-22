List<Object[]> list = Arrays.asList(
        new Object[] { "A", "X", new BigDecimal("1") },
        new Object[] { "A", "Y", new BigDecimal("2.0") },
        new Object[] { "B", "X", new BigDecimal("3.00") },
        new Object[] { "C", "Z", new BigDecimal("4.000") }
);

Map<String, Map<String, BigDecimal>> map = list.stream()
        .collect(Collectors.groupingBy(r -> (String) r[0],
                                       Collectors.toMap(r -> (String) r[1],
                                                        r -> (BigDecimal) r[2])));

System.out.println(map);