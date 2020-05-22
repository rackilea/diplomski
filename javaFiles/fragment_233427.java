File pdfInput = new File("C:\\Rupinder\\MyFile.txt");
byte[] outBytes = new byte[(int)pdfInput.length()];

FileInputStream fileInputStream = new FileInputStream(pdfInput);
fileInputStream.read(outBytes);

ByteArrayOutputStream out = new ByteArrayOutputStream();
out.write(outBytes);

IDfSysObject sysObj = (IDfSysObject)session.newObject("c_pdf");
sysObj.setObjectName("testDoc");
sysObj.setContentType("crtext");
sysObj.setTitle("import operation");
sysObj.link("/Temp/Source Folder"); 
sysObj.setContent(out);
sysObj.save();