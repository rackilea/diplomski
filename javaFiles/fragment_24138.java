File output= new File(outDir, outFilename);

File input= new File(inDir, inFilename);

if (input.exists()) {

FileInputStream inStream = new FileInputStream(input);
FileOutputStream outStream = new FileOutputStream(output);

encryptAndClose(inStream, outStream);   
}