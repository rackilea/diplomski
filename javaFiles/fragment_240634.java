List<String> tableData = new ArrayList<>();
Map<String, Map<String, String>> tableNames = getTableNames();
String[] dates = getDates(table);

for (Map.Entry<String, Map<String, String>> tableEntry : tableNames.entrySet()) {
    tableData.add(tableEntry.getKey());
    tableData.addAll(Arrays.asList(dates));

    for (Map.Entry<String, String> row : tableEntry.getValue().entrySet()) {
        String[] tableRow = getRow(table, row.getValue());
        tableData.add(row.getKey());
        for (String column: tableRow) {
            tableData.add(column);
        }
    }
}
String tableDataString = TextUtils.join(", ", tableData);