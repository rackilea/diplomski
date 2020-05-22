String myZipFile = "...";
byte[] bytes = readFile();
MemoryHeaderReader headerReader = new MemoryHeaderReader(RandomAccessStream.fromBytes(bytes));
ZipModel zipModel = headerReader.readAllHeaders();
FileHeader myFile = Zip4jUtil.getFileHeader(zipModel, myZipFile)
boolean fileIsPresent = myFile != null;