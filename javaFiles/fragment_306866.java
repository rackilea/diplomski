ByteBuffer bbf = ByteBuffer.allocate(9);
bbf.put((byte) 10);
bbf.putInt(100);
bbf.putInt(55);
byte[] msg = bbf.array();

byte[] from4to8 = Arrays.copyOfRange(msg, 1, 5);

ByteBuffer buf2 = ByteBuffer.wrap(from4to8);
System.out.println(buf2.getInt());             // Prints 100