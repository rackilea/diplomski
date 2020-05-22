FileInputStream pdfStream;
try {
   pdfStream = new FileInputStream("file.pdf");
} catch (FileNotFoundException ffne) {
   ffne.printStackTrace();
}
if (pdfStream == null) {
    return;
}

DocFlavor pdfInFormat = DocFlavor.INPUT_STREAM.PDF;
Doc myDoc = new SimpleDoc(pdfStream, pdfInFormat, null);  
PrintRequestAttributeSet aset = 
        new HashPrintRequestAttributeSet();
PrintService service = 
  PrintServiceLookup.lookupDefaultPrintService(psInFormat, aset);
if (service != null) {
   DocPrintJob job = service.createPrintJob();
   try {
        job.print(myDoc, aset);
   } catch (PrintException pe) {
        pe.printStackTrace();
   }
}