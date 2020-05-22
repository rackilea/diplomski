int count = 0;
for (Row row : sheet) {
    if (row.getCell(5) != null) {
        count += 1;
    }
}