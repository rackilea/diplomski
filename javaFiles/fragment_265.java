ByteArrayOutputStream bytes = new ByteArrayOutputStream();
ObjectOutputStream os = new ObjectOutputStream(bytes);
os.writeObject(messageToSend);
os.close();
datagramPacket.setData(bytes.toByteArray());
socket.send(datagramPacket);