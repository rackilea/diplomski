private static final int MESSAGE_SIZE = 20;

public byte[] read() throws IOException {
  final byte[] buffer = new byte[MESSAGE_SIZE];
  int total = 0;
  int read = 0;
  while (total < MESSAGE_SIZE
            && (read = in.read(buffer, total, MESSAGE_SIZE - total)) >= 0) {
    total += read;
  }
  return buffer;
}