byte b = (byte) '1';
CRC32 crc = new CRC32();
crc.update(b);

System.out.printf("%x%n", crc.getValue());
int finalCRC = crc32b((int)crc.getValue());
System.out.printf("%x%n", finalCRC);