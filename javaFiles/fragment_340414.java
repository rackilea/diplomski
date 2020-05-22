File pdffile = new File(multipagepdfPath);
PDFMergerUtility pdf = new PDFMergerUtility();
pdf.setDestinationFileName(pdffile.getPath());
pdf.addSource(page1pdffile);
pdf.addSource(page2pdffile);
pdf.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
//The memory settings depend on if you want to use RAM or Temp files.