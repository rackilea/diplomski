String input = "hello long world";

byte[] bytes = input.getBytes();
LongBuffer tmpBuf = ByteBuffer.wrap(bytes).asLongBuffer();

long[] lArr = new long[tmpBuf.remaining()];
for (int i = 0; i < lArr.length; i++)
    lArr[i] = tmpBuf.get();

System.out.println(input);
System.out.println(Arrays.toString(lArr));
// store longs...

// ...load longs
long[] longs = { 7522537965568945263L, 7955362964116237412L };
byte[] inputBytes = new byte[longs.length * 8];
ByteBuffer bbuf = ByteBuffer.wrap(inputBytes);
for (long l : longs)
    bbuf.putLong(l);
System.out.println(new String(inputBytes));