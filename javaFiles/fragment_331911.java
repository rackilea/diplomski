// first the months
printWriter2.print("Month");
for (Double d : REGISTRY.get("Month")) {
    printWriter2.print("," + d);
}
printWriter2.println();

// now the rest
for (Map.Entry<String, ArrayList<Double>> tuple : REGISTRY.entrySet()) {
    if (!tuple.getKey().equals("Month")) {
        printWriter2.print(tuple.getKey());
        for (Double d : tuple.getValue()) {
            printWriter2.print("," + d);
        }
        printWriter2.println();
    }
}