IntSummaryStatistics statistics = IntStream.of(param).summaryStatistics();

statistics.getAverage();
statistics.getMax();
statistics.getMin();
statistics.getSum();
statistics.getCount();