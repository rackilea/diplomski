public class TestHttpClient {
    public String get(String uri) {
        StreamRecorder streamRecorder = new StreamRecorder();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new ListeningSocketFactory(streamRecorder))
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        try (CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(connManager).build(); CloseableHttpResponse response1 = httpclient.execute(new HttpGet(uri))) {
            HttpEntity entity = response1.getEntity();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            entity.writeTo(byteArrayOutputStream);
            return new String(streamRecorder.getRecordedStreamAsCharArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String s = new TestHttpClient().get("http://onet.pl");
        System.out.println("---------------------\n" +
                "RESULT:\n" +
                "---------------------" +
                "\n" + s.substring(0, Math.min(s.length(), 200)));
    }
}

public class ListeningSocketFactory extends PlainConnectionSocketFactory {
    private final CopyInputStream.InputStreamListener streamListener;

    public ListeningSocketFactory(StreamRecorder streamListener) {
        this.streamListener = streamListener;
    }

    @Override
    public Socket createSocket(HttpContext context) throws IOException {
        return new SocketWithInputStreamListener(streamListener);
    }

}

class StreamRecorder implements CopyInputStream.InputStreamListener {
    private final List<Integer> streamCopy = new ArrayList<>(1000);

    @Override
    public synchronized void processByte(int readByte) {
        streamCopy.add(readByte);
    }

    public synchronized char[] getRecordedStreamAsCharArray() {
        char[] result = new char[streamCopy.size()];
        for (int i = 0; i < streamCopy.size(); i++) {
            result[i] = (char) i;
        }
        return result;
    }
}


public class CopyInputStream extends FilterInputStream {
    private final InputStreamListener streamListener;

    CopyInputStream(InputStream in, InputStreamListener streamListener) {
        super(in);
        this.streamListener = streamListener;
    }

    @Override
    public int read() throws IOException {
        int readByte = super.read();
        processByte(readByte);
        return readByte;
    }

    @Override
    public int read(byte[] buffer, int offset, int count) throws IOException {
        int readBytes = super.read(buffer, offset, count);
        processBytes(buffer, offset, readBytes);
        return readBytes;
    }

    private void processBytes(byte[] buffer, int offset, int readBytes) {
        for (int i = 0; i < readBytes; i++) {
            processByte(buffer[i + offset]);
        }
    }

    private void processByte(int readByte) {
        streamListener.processByte(readByte);
    }

    interface InputStreamListener {
        void processByte(int readByte);
    }
}