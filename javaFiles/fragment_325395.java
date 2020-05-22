byte[] one = getBytesForOne();
byte[] two = getBytesForTwo();
byte[] combined = new byte[one.length + two.length];

System.arraycopy(one,0,combined,0         ,one.length);
System.arraycopy(two,0,combined,one.length,two.length);