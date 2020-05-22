byte[] one = getBytesForOne();
byte[] two = getBytesForTwo();

List<Byte> list = new ArrayList<Byte>(Arrays.<Byte>asList(one));
list.addAll(Arrays.<Byte>asList(two));

byte[] combined = list.toArray(new byte[list.size()]);