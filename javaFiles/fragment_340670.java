ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
byteArrayOutputStream.write(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
    byteArrayOutputStream.toByteArray()
);
final byte[] original = new byte[9];
byteArrayInputStream.read(original);
System.out.println(Arrays.toString(original));