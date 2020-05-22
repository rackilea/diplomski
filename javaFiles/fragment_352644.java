List<List<String>> makeColumns(List<String> linearList) {
    List<List<String>> columns = new ArrayList<>();
    int column = 0;
    for (String s : linearList) {
        if (s.startsWith("***")) {
            ++column;
        } else {
            while (column >= columns.size()) {
                columns.add(new ArrayList<>());
            }
            columns.get(column).add(s);
        }
    }
}