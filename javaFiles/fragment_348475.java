String[] fields = new String[] { "Student's Name", "Father's Name", "Mother's Name", "Address", "Phone No", "Date Of Birth", "Roll NO", "Class", "subjectMajor" };

// Row with index 1 is the second row in Excel sheet
HSSFRow row1 = sheet1.createRow( 1 );

// Filling the row with the given data, one element per cell, 
// starting from the "A" column (cellIndex = 0).
for ( int cellIndex = 0; cellIndex < fields.length; cellIndex++ ) {
    HSSFCell cell = row1.createCell( cellIndex );
    cell.setCellValue( fields[cellIndex] );
}

// Writing a workbook to the disk
try {
    FileOutputStream fileOut = new FileOutputStream( "students.xls" );
    wb.write( fileOut );
    fileOut.close();
} catch ( IOException e ) {
    System.out.println( "IOException:" );
    System.out.println( e.getMessage() );
}