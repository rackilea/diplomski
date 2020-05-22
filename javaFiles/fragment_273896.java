final RowSortedTable<String, String, Double> graph = TreeBasedTable.create();

graph.put("A", "0", 0.0);
graph.put("A", "1", 1.0);
graph.put("B", "0", 0.1);
graph.put("B", "1", 1.1);

final Appendable out = new StringBuilder();
try {
    final CSVPrinter printer = CSVFormat.DEFAULT.print(out);

    printer.printRecords(//
            graph.rowMap().values()//
                    .stream()//
                    .map(x -> x.values())//
                    .collect(Collectors.toList()));

} catch (final IOException e) {
    e.printStackTrace();
}

System.out.println(out);
// 0.0,1.0
// 0.1,1.1