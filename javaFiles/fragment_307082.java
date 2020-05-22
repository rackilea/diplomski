FileInputStream fis = new FileInputStream(zipFile);
byte[] header = new byte[10];
fis.read(header);

int timestamp = header[4] & 0xFF |
            (header[5] & 0xFF) << 8 |
            (header[6] & 0xFF) << 16 |
            (header[7] & 0xFF) << 24; 

// or more simply, use
// int timestamp = ByteBuffer.wrap(header, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

System.out.println(new Date((long) timestamp * 1000)); // this will give you the date