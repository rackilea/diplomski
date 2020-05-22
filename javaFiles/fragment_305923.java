public class RemoteConnection extends Observable {

    private static Logger log = Logger.getLogger(RemoteConnection.class.getName());
    private final Socket socket;
    private final BufferedInputStream in;
    private final BufferedOutputStream out;
    private final static String UTF8 = "UTF-8";

    public RemoteConnection(String host, int port) throws UnknownHostException, IOException {
        socket = new Socket(host, port);
        in = new BufferedInputStream(socket.getInputStream());
        out = new BufferedOutputStream(socket.getOutputStream());
    }

    public void write(Deque<String> commands) throws IOException {
        String command;
        while (!commands.isEmpty()) {
            command = commands.pop();
            out.write(command.concat("\r\n").getBytes(Charset.forName(UTF8)));
            log.info(command);
        }
        out.flush();
    }

    void read() {  //probably should use BufferedStream to better effect..?
        Thread readRemote = new Thread() {

            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                char ch;
                int i;
                while (true) {
                    try {
                        i = in.read();
                        ch = (char) i;
                        sb.append(ch);
                        System.out.print(ch);
                        if (i == 13) {
                            setChanged();
                            notifyObservers(sb.toString());
                            log.fine(sb.toString());
                            sb = new StringBuilder();
                        }
                    } catch (IOException ioe) {
                        log.fine(ioe.toString());
                    }
                }
            }
        };
        readRemote.start();
    }
}