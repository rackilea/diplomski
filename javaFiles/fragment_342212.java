public String methodThatReturnsCellresult() {
    // Other stuffs too.
    String Cellresult;
    Cell a1 = sheet.getCell(columNumber,rowNumber); // gets the contents of the cell of a an excell sheet
    Cellresult = a1.getContents();    // stores the values in the variable named Cellresult
    System.out.println(Cellresult);  
    return Cellresult; // returning the Cellresult value to be used elsewhere, in your case, in Class Y
}