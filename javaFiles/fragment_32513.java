private void initalizeCard() throws ReaderException {
    reader.power(0, Reader.CARD_WARM_RESET);
    reader.setProtocol(0, Reader.PROTOCOL_T0 | Reader.PROTOCOL_T1);

    byte[] sendBuffer={(byte)0xFF, (byte)0xCA, (byte)0x00, (byte)0x00, (byte)0x00};
    byte[] recvBuffer=new byte[300];
    reader.transmit(0, sendBuffer, sendBuffer.length, recvBuffer, recvBuffer.length);
}