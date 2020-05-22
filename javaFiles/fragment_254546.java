package com.test;

   import org.apache.commons.net.ftp.FTPClient;

  import java.io.*;
  import java.util.zip.GZIPInputStream;

public class Main {
public static void main(String[] args) throws IOException {
    BufferedOutputStream streamy;
    FileOutputStream stream;
    FTPClient client;
    client = new FTPClient();
    client.connect("ftp.ncbi.nlm.nih.gov");
    client.login("anonymous", "abc123");
    client.setControlKeepAliveTimeout(300 * 60000);
    client.changeWorkingDirectory("/genomes/all/GCF/000/334/875/GCF_000334875.1_ASM33487v1");
    client.retrieveFile("GCF_000334875.1_ASM33487v1_genomic.fna.gz", streamy = new BufferedOutputStream(stream = new FileOutputStream(new File(System.getProperty("user.dir") + "\\GenomicFNA.gz"))));
    stream.flush();
    streamy.flush();
    stream.close();
    streamy.close();
    client.logout();
    client.disconnect();
    GZIPInputStream gzipInputStream = new GZIPInputStream(new FileInputStream(System.getProperty("user.dir") + "\\GenomicFNA.gz"));
    OutputStream out = new FileOutputStream(System.getProperty("user.dir") + "\\GenomicFNA.fsa");
    byte[] buf = new byte[1024];
    int len;
    while ((len = gzipInputStream.read(buf)) > 0) {
        out.write(buf, 0, len);
    }
    gzipInputStream.close();
    out.close();

}
}