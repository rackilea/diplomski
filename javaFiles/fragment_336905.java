import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class ChunkedResponseServer implements Runnable {
  private static final Logger LOGGER = Logger.getLogger(ChunkedResponseServer.class);

  // Space ' '
  static final byte SP = 32;
  // Tab ' '
  static final byte HT = 9;
  // Carriage return
  static final byte CR = 13;
  // Line feed character
  static final byte LF = 10;

  final int port;

  private volatile boolean cancelled = false;

  public ChunkedResponseServer(int port) {
    LOGGER.info("Chunked response server running on port " + port);
    this.port = port;
  }

  @Override
  public void run() {
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(port);
      while (!cancelled) {
        final Socket connectionSocket = serverSocket.accept();
        handle(connectionSocket);
      }
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void cancel() {
    LOGGER.info("Shutting down Chunked response Server");
    cancelled = true;
  }

  private void handle(Socket socket) throws IOException {
    BufferedReader input = null;
    DataOutputStream output = null;
    try {
      input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      output = new DataOutputStream(socket.getOutputStream());

      addHeaders(output);
      addCRLR(output);

      final String filename = readFilename(input);
      final byte[] content = readContent(filename);
      addContentAsChunk(output, content);

      final String checksum = DigestUtils.md5Hex(content);
      addLastChunkAndChecksumFooter(output, checksum);
      addCRLR(output);

    } finally {
      IOUtils.closeQuietly(input);
      IOUtils.closeQuietly(output);
    }
  }

  private void addLastChunkAndChecksumFooter(DataOutputStream output, String checksum) throws IOException {
    output.writeBytes("0");
    addCRLR(output);
    output.writeBytes("checksum: " + checksum);
    addCRLR(output);
  }

  private void addContentAsChunk(DataOutputStream output, byte[] content) throws IOException {
    output.writeBytes(Integer.toHexString(content.length));
    addCRLR(output);
    output.write(content);
    addCRLR(output);
  }

  private void addCRLR(DataOutputStream output) throws IOException {
    output.writeByte(CR);
    output.writeByte(LF);
  }

  private void addHeaders(DataOutputStream output) throws IOException {
    output.writeBytes("HTTP/1.1 200 OK");
    addCRLR(output);
    output.writeBytes("Content-type: text/plain");
    addCRLR(output);
    output.writeBytes("Transfer-encoding: chunked");
    addCRLR(output);
    output.writeBytes("Trailer: checksum");
    addCRLR(output);
  }

  private String readFilename(BufferedReader input) throws IOException {
    final String initialLine = input.readLine();
    final String filePath = initialLine.split(" ")[1];
    final String[] components = filePath.split("/");
    return components[components.length - 1];
  }

  private byte[] readContent(String filename) throws IOException {
    final InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
    return IOUtils.toByteArray(in);
  }
}