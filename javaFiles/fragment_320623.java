// Use the try-with-resource statement to close all the resources properly
try (HSSFWorkbook workBook = new HSSFWorkbook();
     FileOutputStream fos = new FileOutputStream("/Users/parthpatil/Documents/11.xls")) {

    // Create the Sheet
    HSSFSheet Sheet = workBook.createSheet("products");

    // Create the first row corresponding to the header
    Row header = Sheet.createRow(0);
    header.createCell(0).setCellValue("Product Name");
    header.createCell(1).setCellValue("Product Price");
    header.createCell(2).setCellValue("Product MRP");

    // Ensure that all the List have the same size otherwise throw an exception
    if (al.size() != bl.size() || al.size() != cl.size())
        throw new IllegalStateException("Some data is missing");

    // Iterate over all the list an create the rows of data
    for(int i = 0; i < al.size(); i++){
        // Create the current starting from 1 to al.size()
        HSSFRow row = Sheet.createRow((short) i + 1);
        // Cell of the Product Name
        row.createCell(0).setCellValue(al.get(i));
        // Cell of the Product Price
        row.createCell(1).setCellValue(cl.get(i));
        // Cell of the Product MRP
        row.createCell(2).setCellValue(bl.get(i));
    }
    // Write the result into the file
    workBook.write(fos);
}