private static final String sFileName = "feedobject";
private static final String tempFileName = "feedobject.t";
...

File tempFile = new File(tempFileName);
... // write the file
tempFile.renameTo(new File(sFileName));