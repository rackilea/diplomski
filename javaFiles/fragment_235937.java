Map<Long, BigDecimal> hourAverages = funds.stream()
    //group by minute; as a result we have Map<Long, BigDecimal>
    .collect(toMap(f -> f.createdAt.getTime() / 6000, f -> f.current, BigDecimal::add))
    .entrySet().stream()
    //group by hours; here we use BigDecimal[] to store sum and count; 
    //as a result we have Map<Long, BigDecimal[]>
    .collect(groupingBy(e -> e.getKey() / 60,
            collectingAndThen(
                    reducing(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO},
                        e -> new BigDecimal[]{e.getValue(), BigDecimal.ONE},
                        (a, b) -> new BigDecimal[]{a[0].add(b[0]), a[1].add(b[1])}),
                    //finally divide by count
                    a -> a[0].divide(a[1], BigDecimal.ROUND_UP))));