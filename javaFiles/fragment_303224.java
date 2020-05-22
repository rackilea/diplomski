public class MobileApp extends ReceiverAdapter {

    JChannel channel;

    private void start() throws Exception {
       channel = new JChannel(); // use the default config, udp.xml
        channel.setReceiver(this);
        channel.connect("TomcatCluster");
        channel.close();
    }

    public static void main(String args[]) throws Exception {
        new MobileApp().start();
    }