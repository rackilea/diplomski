final DoubleSummaryStatistics stats =
  Flkn.entrySet().stream().filter(e -> e.getKey().matches("T_[0-9]+_" + k + "_[0-9]+"))
                          .flatMapToDouble(e -> e.getValue().stream().mapToDouble(Double::doubleValue))
                          .summaryStatistics();
System.out.println(stats.getMax());
System.out.println(stats.getMin());