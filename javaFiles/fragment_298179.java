pointcut sampleCall(ByteBuffer bytes) :
    execution(boolean com.example.Sample.myCall(String, String, String, ByteBuffer, ..))
    && args(String, String, String, bytes, ..);

before(ByteBuffer bytes) : sampleCall(bytes) {
    System.out.println("Before sample");
}