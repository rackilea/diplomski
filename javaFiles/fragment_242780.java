int bufferLength = ...;
long address = 0xffffffffff601000L;
int pid = ...;

ByteBuffer bb = ByteBuffer.allocateDirect(bufferLength);

readRam(bb, address, pid);

// use bb...