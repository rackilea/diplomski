public UDPServer() throws IOException {
    initComponents();
    setVisible(true);
    FileRead();
    new Thread(()->runServer()).start();
}