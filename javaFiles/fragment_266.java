byte bytes[] = datagramPacket.getData();
ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(bytes));
Serializable messageReceived = is.readObject();
if(messageReceived instanceof String) {
    handleString((String) messageReceived);
}
else {
   // etc.
}