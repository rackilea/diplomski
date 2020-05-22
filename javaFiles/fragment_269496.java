FileInputStream in = new FileInputStream(args[0]);
FileOutputStream out = new FileOutputStream(args[1]);
byte[] buf = new byte[1024];
int i = 0;
while ((i = in.read(buf)) != -1) {
    out.write(buf, 0, i);
}