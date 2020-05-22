String date=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());

date=date.replaceAll("/","_");
date=date.replaceAll(" ","_");
date=date.replaceAll(":","_");

 FileOutputStream fileOut = new FileOutputStream("F:\\JobStatus_"+date+".xlsx");
 workbook.write(fileOut);
 fileOut.close();