PdfReader reader = new PdfReader(SIGNED); 
AcroFields acroFields = reader.getAcroFields(); 
acroFields.removeField("sig"); 
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(UNSIGNED)); 
stamper.close(); 
reader.close();