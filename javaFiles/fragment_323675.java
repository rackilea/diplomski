for(int i = 0; i < sheet.getLastRowNum(); i++){
    if(isEmpty(sheet.getRow(i)){
        sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
        i--;//Adjusts the sweep in accordance to a row removal
    }
}

boolean isEmpty(Row row){

//Code to determine if a row is empty

}