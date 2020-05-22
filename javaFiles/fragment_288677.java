String buffer = "1234567890";
DWORD dwKeyLength = new DWORD(buffer.length());
ByteBuffer buf = ByteBuffer.allocateDirect(dwKeyLength.intValue()); 
buf.put(buffer.getBytes()); 
Pointer pucKeyData = Native.getDirectBufferPointer(buf);

System.out.println("pucKeyData data:" + pucKeyData.getString(0));

buf = null;
pucKeyData = null;