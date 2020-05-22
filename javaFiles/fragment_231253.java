public static void main(String[] args) {
    File log = new File("packets.log");
    PacketListener listener = new PacketListener();
    Tailer tailer = Tailer.create(log, listener, 2500);
    tailer.run();
}