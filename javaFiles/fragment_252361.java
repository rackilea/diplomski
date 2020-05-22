public class Main {
    public static void main(final String[] args) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(12345);
        final Socket clientSocket = serverSocket.accept();
        final InputStreamReader reader = new InputStreamReader(clientSocket.getInputStream());
        final BufferedReader bufferedReader = new BufferedReader(reader);
        int contentLength = -1;
        while (true) {
            final String line = bufferedReader.readLine();
            System.out.println(line);

            final String contentLengthStr = "Content-Length: ";
            if (line.startsWith(contentLengthStr)) {
                contentLength = Integer.parseInt(line.substring(contentLengthStr.length()));
            }

            if (line.length() == 0) {
                break;
            }
        }

        // We should actually use InputStream here, but let's assume bytes map
        // to characters
        final char[] content = new char[contentLength];
        bufferedReader.read(content);
        System.out.println(new String(content));
    }
}