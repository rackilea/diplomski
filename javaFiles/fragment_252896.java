public void MaxTable(int colIdx, int valueIdx, int... rowIdx) {
     Map<Object, Map<Object, Object>> myList = newRows.stream().collect(
     Collectors.groupingBy(r -> r.get(colIdx),
     Collectors.groupingBy( r -> new PivotColumns(r, rowIdx),
     Collectors.collectingAndThen( Collectors.maxBy(
         Comparator.comparing(r -> (Comparable<Object>)(((List<Object>) r).get(valueIdx)))),
         r -> r.get().get(valueIdx)))));

     System.out.println("Dynamic MAX PIVOT"); System.out.println(myList);
}