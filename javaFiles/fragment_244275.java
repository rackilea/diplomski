byte[] raw = Files.readAllBytes(file.toPath());
ByteArrayOutputStream baos = new ByteArrayOutputStream();
for (byte b : raw)
    if (b != 10 && b != 13)
        baos.write(b);
byte[] result = baos.toByteArray();