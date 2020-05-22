PrintService pservice = ... // acquire print service of your printer
DocPrintJob job = pservice.createPrintJob();  
String commands = "^XA\n\r^MNM\n\r^FO050,50\n\r^B8N,100,Y,N\n\r^FD1234567\n\r^FS\n\r^PQ3\n\r^XZ";
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
Doc doc = new SimpleDoc(commands.getBytes(), flavor, null);
job.print(doc, null);