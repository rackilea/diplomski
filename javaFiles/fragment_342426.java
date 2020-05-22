InputStream is = new FileInputStream(absoluteZipName);
ArchiveInputStream input = new ArchiveStreamFactory()
   .createArchiveInputStream(ArchiveStreamFactory.TAR, new GZIPInputStream(is));

ArchiveEntry entry;
while ((entry = input.getNextEntry()) != null) {
    OutputStream outputFileStream=null;
    if(entry.getName().endsWith(".dat")){
     File outFile1= new File(destination1, entry.getName());
         outputFileStream = new FileOutputStream(outFile1); 
    }
    else if(entry.getName().endsWith(".txt")){
    File outFile2= new File(destination2, entry.getName());
         outputFileStream = new FileOutputStream(outFile2);   
    }
    // use ArchiveEntry#getName() to do the conditional stuff...
    IOUtils.copy(input, outputFileStream,10485760);
}