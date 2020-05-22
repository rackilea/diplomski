Path path = Paths.get("src/main/resources/test.wav");
    final byte[] audio;
    try{
      audio  = Files.readAllBytes(path);
    }
    catch (IOException e) {
            System.out.println("Audio io error");
            e.printStackTrace();     
            return;
        }
    //SERVER
    Configuration config = new Configuration();
    config.setHostname("localhost");
    config.setPort(9092);
    config.setMaxFramePayloadLength(1024 * 1024);
    config.setMaxHttpContentLength(1024 * 1024);

    final SocketIOServer server = new SocketIOServer(config);

    server.addEventListener("updateCoordinates", byte[].class, new DataListener<byte[]>() {
        @Override
        public void onData(SocketIOClient client, byte[] data, AckRequest ackRequest) {
            //System.out.println("Just gonna send it");
            client.sendEvent("sound", audio);
        }
    });

    server.start();

    Thread.sleep(Integer.MAX_VALUE);

    server.stop();
}