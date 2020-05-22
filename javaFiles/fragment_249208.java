ProcessBuilder pb = new ProcessBuilder("your_command", "arg1", "arg2");
pb.directory(new File("C:/Documents and Settings/username/"));

OutputStream out = new FileOutputStream("filename.txt");
InputStream in = pb.start().getInputStream();

byte[] buf = new byte[1024];
int len;
while ((len = in.read(buf)) > 0)
    out.write(buf, 0, len);

out.close();