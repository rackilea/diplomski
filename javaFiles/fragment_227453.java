String myFile="C:" + File.separator + "tmpfile.jpg";
File f = new File(myFile);
FileOutputStream fos = null;
try {
    fos = new FileOutputStream(f);
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(
                             new BufferedOutputStream(fos));
    encoder.encode(biFullView);
}
catch (SecurityException ee) {
    System.out.println("writeFile: caught security exception");
}
catch (IOException ioe) {
    System.out.println("writeFile: caught i/o exception");
}finally{
    if(fos != null) fos.close();
}