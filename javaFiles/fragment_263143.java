public void SendMessage() throws IOException
{
    for(int i = 0;i<MESSAGE_SIZE;i++)
        message+='\0';
    for(int i = 0;i<ID_SIZE;i++)
        id+='\0';
    ByteBuffer bbuf = ByteBuffer.allocate(1000);
    bbuf.put(id.getBytes());
    bbuf.position(33);
    bbuf.putInt(33,length);
    bbuf.position(37);
    bbuf.put(message.getBytes());
    bbuf.flip();
    for(Session session : sessionList)
        session.getAsyncRemote().sendBinary(bbuf);
    System.out.println("sent");
}