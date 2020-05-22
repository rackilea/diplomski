//Value of row 9, column 1 (column B)
String B9 = firstSheet.getRow(9).getCell(1).getStringCellValue();

//Value of row 9, column 2 (column C)
String D9 = firstSheet.getRow(9).getCell(2).getStringCellValue();

//Value of row 9, column 3 (column D)
String D9 = firstSheet.getRow(9).getCell(3).getStringCellValue();

//do math B9 - D9
double value = Double.parseDouble(B9) - Double.parseDouble(D9);

//check if C9 matches the result of B9 - D9
if(value == Double.parseDouble(C9))
{
    //if it matches set cell E9 to display "Matched" and print out a message
    firstSheet.getRow(9).getCell(4).setCellValue("matched");
    System.out.println("matched");
}