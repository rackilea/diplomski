char sep = PRFile.separatorChar;
String exportPath= tools.getProperty("pxProcess.pxServiceExportPath").getStringValue();
DateTimeUtils dtu = ThreadContainer.get().getDateTimeUtils();

String fileNameParam = tools.getParamValue("FileName");
if(fileNameParam.equals("")){
    fileNameParam = "RecordsToCSV";
}

//append a time stamp
Boolean appendTimeStamp = tools.getParamAsBoolean(ImmutablePropertyInfo.TYPE_TRUEFALSE,"AppendTimeStampToFileName");
FileName += fileNameParam;
if(appendTimeStamp) {
  FileName += "_";
  String currentDateTime = dtu.getCurrentTimeStamp();
  currentDateTime = dtu.formatDateTime(currentDateTime, "HH-mm-ss_dd.MM.yyyy", "", "");
  FileName += currentDateTime;
}

//append a file format
FileName += ".csv";

String strSQLfullPath = exportPath + sep + FileName;
PRFile f = new PRFile(strSQLfullPath);

PROutputStream stream = null;
PRWriter out = null;
try {
 // Create file 
 stream = new PROutputStream(f);
 out = new PRWriter(stream, "UTF-8");

 // Bug with Excel reading a file starting with 'ID' as SYLK file. If CSV starts with ID, prepend an empty space.
 if(CSVString.startsWith("ID")){
    CSVString=" "+CSVString;
 }
 out.write(CSVString);
} catch (Exception e) {
 oLog.error("Error writing csv file: " + e.getMessage());
} finally {
  try {
    // Close the output stream
    out.close();
  } catch (Exception e) {
    oLog.error("Error of closing a file stream: " + e.getMessage());
  }
}