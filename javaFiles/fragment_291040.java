// you declare the interface as declared type and the chosen implementation 
 // is determined at runtime according to your requirements
Populatable populatable = ...; 

while(tfr.hasData()){
    currentRecord = tfr.getNextLine();
    currentRecord = currentRecord.trim();
    populatable.populate(currentLine);
}