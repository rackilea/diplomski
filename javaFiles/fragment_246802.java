int i;
byte[] buffer = new byte[2048];
i = in.read(buffer);
for (int j = 0; j < i; j++) {
    buff.append((char) buffer[j]);
}
System.out.println(buff.toString());