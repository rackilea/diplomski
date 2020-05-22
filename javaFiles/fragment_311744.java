Map<String, ArrayList<String>> matrix = new HashMap<String, ArrayList<String>>();

int cell=0;
int row=0;
for (Map.Entry<String,Object> e : matrix.entrySet()) {           
    worksheet.createRow(row++).createCell(cell).setCellValue(e.getKey());
    Row valueRow = worksheet.createRow(row++);
    for (String v : e.getValue()) {
        valueRow.createCell(cell++).setCellValue(v);
    }
}