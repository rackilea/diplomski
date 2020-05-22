ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());

....
ze = new ZipEntry("xlsData");
zos.putEntry (ze);
// loop
zos.write(buf, 0, (int) length);  

// finally 
zos.close();