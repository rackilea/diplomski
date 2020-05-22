public class PacketListener extends TailerListenerAdapter {

    @Override
    public void handle(String line) {
        System.out.println("Inbound: " + line);
    }

}