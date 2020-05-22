public List<String[]> selectColumns(String[] csvFile, String... columns) {
    List<String[]> rows = new ArrayList<>();
    // Split the first row to get the column names.
    String[] columnNames = csvFile[0].split(",");
    // Build a map to get the column number from the name.
    Map<String, Integer> columnNumbers = new HashMap<>();
    for (int i = 0; i < columnNames.length; i++) {
        columnNumbers.put(columnNames[i], i);
    }
    // Put the title columns in.
    String[] colHeaders = new String[columns.length];
    for (int i = 0; i < columns.length; i++) {
        colHeaders[i] = columns[i];
    }
    rows.add(colHeaders);
    // Walk the rest of the file.
    for (int i = 1; i < csvFile.length; i++) {
        // Get and split the line.
        String[] values = csvFile[i].split(",");
        // Collect the required columns.
        String[] row = new String[columns.length];
        for (int j = 0; j < columns.length; j++) {
            // Look up the column number from the header map.
            row[j] = values[columnNumbers.get(columns[j])];
        }
        // Add the row.
        rows.add(row);
    }
    return rows;
}

public void test() {
    // In-line data for demonstration.
    String[] csvFile = new String[]{
        "key,id.attr.id,id.attr.id1,id.attr.id2,id.attr.id7,id.attr.arry,id.attr.arry1,id.attr.arry2,id.attr.arry5,id.attr.arry4",
        "1,0,,,8,,,8,,8",
        "2,3,,,7,,,7,,7",
        "3,4,,,8,,,8,,8",
        "4,5,,,7,,,7,,7",
        "5,4,,,8,,,8,,8",
        "6,3,,,7,,,7,,7",
        "7,4,,,8,,,8,,8",
        "8,5,,,7,,,7,,7",
        "9,3,,,8,,,8,,8",
        "10,6,,,7,,,7,,7"
    };
    List<String[]> selected = selectColumns(csvFile, "key", "id.attr.id", "id.attr.id7");
    for (String[] row : selected) {
        System.out.println(Arrays.toString(row));
    }

}