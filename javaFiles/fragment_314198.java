IntSummaryStatistics summaryStatistics = Stream.of(0.55f, 0.45f, 0.5f, 0.65f, 0f)
            .filter(i -> i > 0.5)
            .mapToInt(i -> (int) (i * 100 - 50))
            .summaryStatistics();

    summaryStatistics.getSum();
    summaryStatistics.getCount();