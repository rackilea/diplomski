import java.net.*;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.nio.channels.*;

public class GZIPTest {
    // Here is a wrapper class that wraps an InputStream
    // but always returns > 0 when .available() is called.
    // This will cause GZIPInputStream to always make another 
    // call to the InputStream to check for an additional 
    // concatenated GZIP file in the stream.
    public static class AvailableInputStream extends InputStream {
        private InputStream is;

        AvailableInputStream(InputStream inputstream) {
            is = inputstream;
        }

        public int read() throws IOException {
            return(is.read());
        }

        public int read(byte[] b) throws IOException {
            return(is.read(b));
        }

        public int read(byte[] b, int off, int len) throws IOException {
            return(is.read(b, off, len));
        }

        public void close() throws IOException {
            is.close();
        }

        public int available() throws IOException {
            // Always say that we have 1 more byte in the
            // buffer, even when we don't
            int a = is.available();
            if (a == 0) {
                return(1);
            } else {
                return(a);
            }
        }
    }



    public static void main(String[] args) throws Exception {
        // Our three test files from CommonCrawl
        URL url0 = new URL("https://commoncrawl.s3.amazonaws.com/crawl-data/CC-MAIN-2016-50/segments/1480698540409.8/wet/CC-MAIN-20161202170900-00009-ip-10-31-129-80.ec2.internal.warc.wet.gz");
        URL url40 = new URL("https://commoncrawl.s3.amazonaws.com/crawl-data/CC-MAIN-2016-50/segments/1480698540409.8/wet/CC-MAIN-20161202170900-00040-ip-10-31-129-80.ec2.internal.warc.wet.gz");
        URL url500 = new URL("https://commoncrawl.s3.amazonaws.com/crawl-data/CC-MAIN-2016-50/segments/1480698541142.66/wet/CC-MAIN-20161202170901-00500-ip-10-31-129-80.ec2.internal.warc.wet.gz");

        /*
         * Test the URLs and display the results
         */
        test(url0, "testfile0.wet");
        System.out.println("------");
        test(url40, "testfile40.wet");
        System.out.println("------");
        test(url500, "testfile500.wet");
    }

    public static void test(URL url, String testGZFileName) throws Exception {
        System.out.println("Testing URL "+url.toString());

        // First directly wrap the HTTP inputStream with GZIPInputStream
        // and count the number of bytes we read
        // Go ahead and save the extracted stream to a file for further inspection
        System.out.println("Testing HTTP Input Stream direct to GZIPInputStream");
        int bytesFromGZIPDirect = 0;
        URLConnection urlConnection = url.openConnection();
        // Wrap the HTTPInputStream in our AvailableHttpInputStream
        AvailableInputStream ais = new AvailableInputStream(urlConnection.getInputStream());
        GZIPInputStream gzipishttp = new GZIPInputStream(ais);
        FileOutputStream directGZIPOutStream = new FileOutputStream("./"+testGZFileName);
        int buffersize = 1024;
        byte[] buffer = new byte[buffersize];
        int bytesRead = -1;
        while ((bytesRead = gzipishttp.read(buffer, 0, buffersize)) != -1) {
            bytesFromGZIPDirect += bytesRead;
            directGZIPOutStream.write(buffer, 0, bytesRead); // save to file for further inspection
        }
        gzipishttp.close();
        directGZIPOutStream.close();

        // Save the GZIPed file locally
        System.out.println("Testing saving to file before decompression");
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream outputStream = new FileOutputStream("./test.wet.gz");
        outputStream.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        // Now decompress the local file and count the number of bytes
        int bytesFromGZIPFile = 0;
        GZIPInputStream gzipis = new GZIPInputStream(new FileInputStream("./test.wet.gz"));

        buffer = new byte[1024];
        while((bytesRead = gzipis.read(buffer, 0, 1024)) != -1) {
            bytesFromGZIPFile += bytesRead;
        }
        gzipis.close();

        // The Results
        System.out.println("Read "+bytesFromGZIPDirect+" bytes from HTTP->GZIP");
        System.out.println("Read "+bytesFromGZIPFile+" bytes from HTTP->file->GZIP");
        System.out.println("Output from HTTP->GZIP saved to file "+testGZFileName);
    }

}