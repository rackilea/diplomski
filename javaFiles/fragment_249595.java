try {

while(param1> 0) {
// Instantiate the 1st bubble file
file = new File(TARGET_DIR, String.valueOf(Calendar.getInstance().getTimeInMillis()));

while(param2 > 0) {                        
randomAccessFile = new RandomAccessFile(file, "rwd");
fc = randomAccessFile.getChannel();
fc.position(fc.size());
synchronized (mSignal) {
tempBytesWritten = fc.write(ByteBuffer.wrap(arr));
totalBytesWritten += tempBytesWritten;
}
// some other things that don't matter
}