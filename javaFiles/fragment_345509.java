TTransport transport;

try {
    transport = new TSocket("localhost", Config.THRIFT_PORT);        
    transport.open();

    TProtocol protocol = new TBinaryProtocol(new TFramedTransport(transport));
    PringService.Client client = new PringService.Client(protocol);

    String result = client.importPringer(2558456, true);

    System.out.println("Result String is ::"+result);
    transport.close();
} catch (TTransportException e) {
    e.printStackTrace();
} catch (TException e) {
    e.printStackTrace();
}