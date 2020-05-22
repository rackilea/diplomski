// encrypted data in array
byte[] data = ...

FileOutputStream fos = ...
fos.write(data, 0, data.length);
fos.flush();
fos.close();