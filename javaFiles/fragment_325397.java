byte[] allByteArray = new byte[one.length + two.length + three.length];

ByteBuffer buff = ByteBuffer.wrap(allByteArray);
buff.put(one);
buff.put(two);
buff.put(three);

byte[] combined = buff.array();