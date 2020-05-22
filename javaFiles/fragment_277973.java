Factory fac = new AsyncClient.Factory(new TAsyncClientManager(), new TProtocolFactory() {
    @Override
    public TProtocol getProtocol( TTransport trans ) {
        return new TBinaryProtocol(trans);
    }
});
AsyncClient cl = fac.getAsyncClient( new TNonblockingSocket( "127.0.0.1", 12345 ));