public class StartOnce {

  public static void main(String args[]) throws IOException {
    SocketAddress addr = new InetSocketAddress("127.0.0.1", 9999);

    try {
        ServerSocket ss = new ServerSocket();
        // tries to bind to localhost:9999
        ss.bind(addr);
        // Ok, I'm the first instance, listen for other instances for update.
        while(true) {
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            s.close();
        }
    } catch (BindException e) {
        // BindException, tries to send message to the first instance.
        System.out.println("Another instance is running. Say hi.");
        Socket s = new Socket();
        s.connect(addr);
        PrintWriter pw = new PrintWriter(s.getOutputStream());
        pw.println("Hello.");
        for (String arg : args) {
            pw.println(arg);
        }
        pw.close();
        s.close();
    }
  }
}