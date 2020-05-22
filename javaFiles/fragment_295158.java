File file = new File("a.txt");
FileInputStream fis = new FileInputStream(file);
byte[] data = new byte[(int) file.length()];
fis.read(data);
fis.close();

String str = new String(data, "UTF-8");