ByteArrayOutputStream baos = new ByteArrayOutputStream();
DataOutputStream w = new DataOutputStream(baos);

w.writeInt(100);
w.write(byteArray);

w.flush();

byte[] result = baos.toByteArray();