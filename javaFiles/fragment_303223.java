public class TomcatServer {

    JChannel channel;

    private void start() throws Exception {
        channel = new JChannel(); // use the default config, udp.xml
        channel.connect("TomcatCluster");
    }

    public static void main(String[] args) throws Exception {
        new TomcatServer().start();
    }
}