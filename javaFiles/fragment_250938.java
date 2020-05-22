@Test
public void testSendPedido() throws Exception{
    Thread thread = new Thread(new Servidor());
    thread.start();
    ...
}