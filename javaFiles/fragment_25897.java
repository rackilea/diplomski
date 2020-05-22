//Read first line 
String dataRow;
int lineNumber = 0;
while((dataRow = CSVFile.readline()) != null)
{
    String [] dataArray;
    lineNumber++;
    String delimiter = "\t";
    dataArray = dataRow.split(delimiter); //Now dataArray contains all the tab delimited cells that were on line one of the .txt file
    //Start assigning the information to your variables since it is stored in dataArray
    String PrinterName = dataArray[0];//This would assign the first cell (row 1, column 1 in excel) that was read from the text file. From looking at your input this should be "Printer name"
    String Model = dataArray[1];
    String IP = dataArray[2];
    //etc...Assign the rest
    //Print your output
    //Do anything else you need to do
 }//end the while loop