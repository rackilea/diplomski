File inputFile = new File("utf-8-data.txt");
File outputFile = new File("latin-1-data.zip");

ZipEntry entry = new ZipEntry("latin-1-data.txt");

BufferedReader reader = new BufferedReader(new FileReader(inputFile));

ZipOutputStream zipStream = new ZipOutputStream(new FileOutputStream(outputFile));
BufferedWriter writer = new BufferedWriter(
    new OutputStreamWriter(zipStream, Charset.forName("ISO-8859-1"))
);

zipStream.putNextEntry(entry);

// this is the important part:
// all character data is written via the writer and not the zip output stream
String line = null;
while ((line = reader.readLine()) != null) {
    writer.append(line).append('\n');
}
writer.flush(); // i've used a buffered writer, so make sure to flush to the
// underlying zip output stream

zipStream.closeEntry();
zipStream.finish();

reader.close(); 
writer.close();