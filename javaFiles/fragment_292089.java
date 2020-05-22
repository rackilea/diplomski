private static class PortReader implements SerialPortEventListener {
    private short msgLength;
    private short msgLengthLeft;
    private byte[] receivedMsg = new byte[packetSize];
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );

    @Override
    public void serialEvent(SerialPortEvent event) {
        if(event.isRXCHAR() && event.getEventValue() > 0) {
            try {
                byte[] receivedData = serialPort.readBytes(event.getEventValue());
                if(Utils.isConfirmPacket(Utils.toHex(receivedData))){
                    System.out.println("XBee confim that msg is sent!");
                }else{
                    if(receivedData[0] == 0x7e){    //0x7e is the start delimiter of a frame
                        ByteBuffer wrapped = ByteBuffer.wrap(receivedData,1,2); // big-endian by default
                        msgLength = (short) (wrapped.getShort()+4); //Need to add 4 to the value becaus some field are not include in the length field of the api packet
                        msgLengthLeft = (short) (msgLength - receivedData.length);
                        outputStream.write(receivedData);  
                        return;
                    }else{
                        msgLengthLeft = (short) (msgLengthLeft - receivedData.length);
                        outputStream.write(receivedData); 
                        if(msgLengthLeft != 0){
                            return;
                        }
                    }
                    System.out.println("Received response from port: " + Utils.toHex(outputStream.toByteArray( )));
                    int dataLength = Utils.toHex(receivedMsg).length();
                    //receiveFile("testRx", receivedData, dataLength);
                }

            }
            catch (SerialPortException | IOException ex) {
                System.out.println("Error in receiving response from port: " + ex);
            }
        }
    }
}