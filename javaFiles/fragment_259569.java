public void extractFile(String path) throws FileNotFoundException {

    String zipFileName = "/mnt/sdcard/Bluetooth/" + path;
    String extractedFileName = getApplicationContext().getFilesDir()
            .getPath().toString()
            + "Finger.FIR";

    ZipInputStream inStream = new ZipInputStream(new FileInputStream(
            zipFileName));
    OutputStream outStream = new FileOutputStream(extractedFileName);

    unpackZip(path ,zipFileName)



    /*Toast.makeText(getApplicationContext(), zipFileName,
            Toast.LENGTH_SHORT).show();*/

}

private boolean unpackZip(String path, String zipname)
{       
     InputStream is;
     ZipInputStream zis;
     try 
     {
         String filename;
         is = new FileInputStream(path + zipname);
         zis = new ZipInputStream(new BufferedInputStream(is));          
         ZipEntry ze;
         byte[] buffer = new byte[1024];
         int count;

         while ((ze = zis.getNextEntry()) != null) 
         {
             // zapis do souboru
             filename = ze.getName();
             FileOutputStream fout = new FileOutputStream(path + filename);

             // cteni zipu a zapis
             while ((count = zis.read(buffer)) != -1) 
             {
                 fout.write(buffer, 0, count);             
             }

             fout.close();               
             zis.closeEntry();
         }

         zis.close();
     } 
     catch(IOException e)
     {
         e.printStackTrace();
         return false;
     }

    return true;
}