File f = new File("bin/" + className.replace('.', File.separatorChar) + ".class");
DataInputStream is = new DataInputStream(new FileInputStream(f));
int len = (int)f.length();
byte[] buff = new byte[len];
is.readFully(buff);
is.close();
return buff;