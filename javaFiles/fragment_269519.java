public void loadResult( Scanner input ) {
 while ( input.hasNextLine() ) {
    String line=input.nextLine();

    sPrinterName = line.subString(0, line.indexOf(' '));// printer name
    sContent = line.subString(line.indexOf(' ')+1);  // get string ( print job )

    List<String> contentList=mapOfJobs.get(sPrinterName);
    if(contentList==null ){
       contentList=new ArrayList<>();
     }
     contentList.add(sContent);
     mapOfJobs.put(sPrinterName,contentList)
  }
}