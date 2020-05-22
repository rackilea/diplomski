File file = new File("path/to/pdf");
DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
attr.add(MediaSizeName.ISO_A4);
FileInputStream fis = new FileInputStream(file);
Doc doc = new SimpleDoc(fis, flavor, null);
DocPrintJob job = printService.createPrintJob();
job.print(doc, attr);
fis.close();