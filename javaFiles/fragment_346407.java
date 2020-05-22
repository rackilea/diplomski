ByteArrayOutputStream baos = new ByteArrayOutputStream();
ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
DeflaterOutputStream dos = new DeflaterOutputStream(baos, true);

for (char ch = 'a'; ch <= 'z'; ch++) {
    dos.write(("Hello world").getBytes());
    baos2.write(("Hello world").getBytes());
    dos.flush();
    System.out.println("compressed size = " + baos.toByteArray().length);
}
dos.close();
System.out.println("After close, compressed size = " + baos.toByteArray().length);
System.out.println("uncompressed size = " + baos2.toByteArray().length);