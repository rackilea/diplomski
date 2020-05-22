new MockUp<NetworkClient>() {
    @Mock
    public void $init(Invocation inv){
        NetworkClient client = inv.getInvokedInstance();
        Deencapsulation.setField(client, "nrh", new ServerRequestHandler());
    }   
  };