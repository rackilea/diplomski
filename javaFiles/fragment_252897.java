public void AverageTable(int colIdx, int valueIdx, int... rowIdx) {
    Map<Object, Map<Object, Double>> myList = newRows.stream().collect(
            Collectors.groupingBy(r -> r.get(colIdx), Collectors
                    .groupingBy(r -> new PivotColumns(r, rowIdx),
                            Collectors.averagingDouble(r -> ((Number) (r
                                    .get(valueIdx))).doubleValue()))));

    System.out.println("Dynamic AVG PIVOT"); System.out.println(myList);
}