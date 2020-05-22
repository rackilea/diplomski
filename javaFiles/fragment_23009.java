public FrmServer() throws HeadlessException {
    setTitle("Server");
    setLayout(new BorderLayout());

    addContent();
    addSend();

    setSize(400, 300);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    chat();
}
private ServerSocket serverInfo;
private Socket clientInfo;
private ObjectInputStream ois;
private ObjectOutputStream oos;

private void chat() {
    Runnable runnable = new Runnable() {
        public void run() {
            try {
                serverInfo = new ServerSocket(12345);

                clientInfo = serverInfo.accept();
                ois = new ObjectInputStream(clientInfo.getInputStream());

                oos = new ObjectOutputStream(clientInfo.getOutputStream());

                while (true) {
                    String data = ois.readObject().toString();
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run(){
                            txtContent.append("Client :" + data + "\n");
                        }
                    });
                }
            } catch (Exception ex) {
            }

        }
    };
    //You can use a ThreadPool too.
    new Thread(runnable).start();
}