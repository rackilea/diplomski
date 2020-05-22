class Program {
    public void sendMessage() {
        ConnectionProxy proxy = new ConnectionProxy();
        if (!proxy.isConnected()) {
            // I guess noone connected it
            return;
        }
        proxy.sendBytes();
    }
 }