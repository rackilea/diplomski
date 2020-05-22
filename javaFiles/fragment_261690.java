File file = new File("filename.bin");
byte[] fileData = new byte[file.length()];
FileInputStream in = new FileInputStream(file);
in.read(fileData):
in.close();
// now fileData contains the bytes of the file