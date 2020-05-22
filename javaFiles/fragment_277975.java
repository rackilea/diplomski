// Make the pool
Thrift t = new Thrift( 10, "localhost", 8000 );
// Use the pool
t.req( new ThriftRequest() {

    @Override
    public void on( AsyncClient cli ) {
        cli.MyThriftMethod( "stringarg", 111, new AsyncMethodCallback<AsyncClient.MyThriftMethod_call>() {
            @Override
            public void onError( Throwable throwable ) {
                }

            @Override
            public void onComplete( MyThriftMethod_call response ) {
            }
        });
    }
} );