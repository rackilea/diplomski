public static void main(String[] args) throws Exception {
    final String input = "{{\"12\",\"13\",\"2\",\"5\"},{\"14\",\"14\",\"1\",\"4\"},{\"36\",\"30\",\"1\",\"9\"}}";
    final String[] rows = input.replaceAll("^\\{\\{|}}$", "").split("},\\{");
    final List<List<String>> transformed = new ArrayList<>();
    for (final String row : rows) {
        final String[] columns = row.replaceAll("^\"|\"$", "").split("\",\"");
        final List<String> transformedRow = new ArrayList<>();
        for (final String data : columns) {
            transformedRow.add(data);
        }
        transformed.add(transformedRow);
    }
}