Map<Tuple1<String>, LongSummaryStatistics> grouped = join.stream()
        .collect(Collectors.groupingBy(Tuples::of,
                () -> new TreeMap<>(comparator),
                Collectors.summarizingLong(t -> t.get2().getLDiscount()
                        .multiply(BigDecimal.ONE
                        .subtract(t.get2().getLDiscount())).longValue())
        ));