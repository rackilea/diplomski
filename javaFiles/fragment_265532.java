// read first line of file
// get the amountOfRecords field from the line
String[] lines = new String[amountOfRecords]
int amountOfLinesInArray = 0;
// loop through file till end of file
   if(amountOfLinesInArray >= amountOfRecords) {
     // error! header information was corrupt!
   } else {
     lines[amountOfLinesInArray++] = line;
   }