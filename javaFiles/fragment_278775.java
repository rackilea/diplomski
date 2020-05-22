short loc = (short) writeLocation;

byte[] bucket = ...
int idex = bucket.length - 2;
ByteBuffer buf = ByteBuffer.wrap(bucket);
buf.order(ByteOrder.LITTLE__ENDIAN); // Optional
buf.putShort(index, loc);

writeLocation = buf.getShort(index);