// create a new POIFSFileSystem, which is the container for 
// encrypted OOXML-based files  
POIFSFileSystem fs = new POIFSFileSystem();
EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);

// setup the encryption
Encryptor enc = info.getEncryptor();
enc.confirmPassword("foobaa");

// after writing to the SXSSF workbook you need the content
// as a stream
InputStream is = <open the SXSSF workbook as stream>
OutputStream os = enc.getDataStream(fs);
// copy the stream to the OutputStream
IOUtils.copy(is, os);

// Write out the encrypted version
FileOutputStream fos = new FileOutputStream("...");
fs.writeFilesystem(fos);
fos.close();