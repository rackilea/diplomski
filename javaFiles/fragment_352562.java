List<Branch> content = new ArrayList<>();
for (int r = headerRowNum + 1; r <= sheet.getLastRowNum(); r++) {
    row = sheet.getRow(r);
    if (row == null)
        continue; //SKIP, don't bother creating empty stuff!
    Branch branch = new Branch();
    for (Map.Entry<Integer, String> entry : colHeaders.entrySet()) {
        int colIdx = entry.getKey();
        Cell cell = row.getCell(colIdx);
        if (cell != null) {
            String cellValue = formatter.formatCellValue(cell, evaluator);
            switch(entry.getValue()) {
                 case "Description": {
                      branch.setDescription(cellValue);
                      break;
                 }
                 case "name": //example with multiple headers mapping to same field
                 case "Label": {
                      branch.setLabel(cellValue);
                       break;
                 }
            }
            //alternatively use if-else block with regex matching or some other technique to map your headers to JPA entity fields
        }
    }
    content.add(branch);
}