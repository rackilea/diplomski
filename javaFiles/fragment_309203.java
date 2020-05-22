fisNew = new FileInputStream(newWorkbook);
   oldWB = WorkbookFactory.create(new File(oldWorkbook));
   newWB = WorkbookFactory.create(fisNew);
...
   fileOut = new FileOutputStream(newWorkbook);
   newWB.write(fileOut);
   fileOut.close();

   oldWB.close();
   newWB.close();