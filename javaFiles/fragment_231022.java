InputStream reader = new BufferedInputStream(
   object.getObjectContent());
File file = new File("localFilename");      
OutputStream writer = new BufferedOutputStream(new FileOutputStream(file));

int read = -1;

while ( ( read = reader.read() ) != -1 ) {
    writer.write(read);
}

writer.flush();
writer.close();
reader.close();