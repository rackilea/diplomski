Multiclient() throws IOException
{
    socket = new Socket("127.0.0.1", 1036);
    System.out.println(socket);
    Mythreadc my = new Mythreadc(socket);
    ClientReaderThread reader = new ClientReaderThread(socket);
    my.start();
    reader.start();
}