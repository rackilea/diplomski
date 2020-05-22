public class TextSocket implements Closeable {
    final Socket socket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public TextSocket(String hostname, int port) throws IOException {
        this(new Socket(hostname, port));
    }

    public TextSocket(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
    }

    public String sendAndRead(String msg) throws IOException {
        writer.println(msg);
        if (writer.checkError())
            throw new IOException("Unable to write");
        writer.flush();
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }
}