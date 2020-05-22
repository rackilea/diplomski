public void sendData(final String data) {

    ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
    peerConnectionClient.getPCDataChannel().send(new DataChannel.Buffer(buffer, false));


}