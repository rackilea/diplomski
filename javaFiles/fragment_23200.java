Iterator<Row> iterator = firstSheet.iterator();

while (iterator.hasNext()) {
    Row nextRow = iterator.next();

    //Check to make sure we skip the first row because that has all the column names:
    if (nextRow.getRowNum() != 0){
        //Get cell values of the current row
        String columnB = nextRow.getCell(1).getStringCellValue();
        String columnC = nextRow.getCell(2).getStringCellValue();
        String columnD = nextRow.getCell(3).getStringCellValue();

        try{
            //do math column B - column D
            double value = Double.parseDouble(columnB) - Double.parseDouble(columnD);

            //check if column C matches the result of (column B - column D)
            if(value == Double.parseDouble(columnC)){
                //if it matches set text in column E to "matched"
                nextRow.getCell(4).setCellValue("matched");
                //print to console showing if a row matched
                System.out.println("Row " + (nextRow.getRowNum()+1) + " matched");
            }
        }
        catch(NumberFormatException nfe){
            //do nothing here, this will happen if a cell contains text instead of numbers 
        }
        catch(NullPointerException npe){
            //Something else happened, you can probably ignore this as well but it will pay to throw a stack trace just in case something is wrong with this code
            npe.printStackTrace();
        }
    }
}