byte[] buffer = baos.toByteArray();
byte[] info = information.getBytes();
byte[] length = intToBytes(buffer.length);
byte[] concat = new byte[length.length + buffer.length + info.length];
System.arraycopy(length, 0, concat, 0, buffer.length);
System.arraycopy(buffer, 0, concat, length.length, buffer.length);
System.arraycopy(info, 0, concat, buffer.length + length.length, info.length);