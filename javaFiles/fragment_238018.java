public static void main(String [] args) {
    try {
      MyAppServiceHandler handler = new MyAppServiceHandler();
      MyApp.Processor processor = new MyApp.Processor(handler);
      TServerTransport serverTransport = new TServerSocket(8080);
      TServer server = null;
      server = new TSimpleServer(processor, serverTransport);
      System.out.println("Starting thrift server...");
      server.serve();
    }
    catch (TTransportException e) {
      e.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
}