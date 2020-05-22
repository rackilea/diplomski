List<List<String>> columns = makeColumns(...);
int rows = columns.stream().mapToInt(List::size).max().orElse(0);

for (int rowi = 0; rowi < rows; ++rowi) {
    XSSFRow row = outputSheet.createRow(rowi + 1);
    for (int coli = 0; coli < columns.size(); ++coli) {
        if (rowi < columns.get(coli).size()) {
            String value = columns.get(coli).get(rowi);
            row.createCell(coli);
            ...
        }
    }
}