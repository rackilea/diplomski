public class Thrift {

    // This is the request
    private static abstract class ThriftRequest {

        private void go( final Thrift thrift, final AsyncClient cli ) {
            on( cli );
            thrift.ret( cli );
        }

        public abstract void on( AsyncClient cli );
    }

    // Holds all of our Async Clients
    private final ConcurrentLinkedQueue<AsyncClient>   instances = new ConcurrentLinkedQueue<AsyncClient>();
    // Holds all of our postponed requests
    private final ConcurrentLinkedQueue<ThriftRequest> requests  = new ConcurrentLinkedQueue<ThriftRequest>();
    // Holds our executor, if any
    private Executor                                 exe       = null;

    /**
     * This factory runs in thread bounce mode, meaning that if you call it from 
     * many threads, execution bounces between calling threads depending on when        
     * execution is needed.
     */
    public Thrift(
            final int clients,
            final int clients_per_message_processing_thread,
            final String host,
            final int port ) throws IOException {

        // We only need one protocol factory
        TProtocolFactory proto_fac = new TProtocolFactory() {

            @Override
            public TProtocol getProtocol( final TTransport trans ) {
                return new TBinaryProtocol( trans );
            }
        };

        // Create our clients
        Factory fac = null;
        for ( int i = 0; i < clients; i++ ) {

            if ( fac == null || i % clients_per_message_processing_thread == 0 ) {
                fac = new AsyncClient.Factory(
                    new TAsyncClientManager(),
                    proto_fac );
            }

            instances.add( fac.getAsyncClient( new TNonblockingSocket(
                host,
                port ) ) );
        }
    }
    /**
     * This factory runs callbacks in whatever mode the executor is setup for,
     * not on calling threads.
     */
    public Thrift( Executor exe,
            final int clients,
            final int clients_per_message_processing_thread,
            final String host,
            final int port ) throws IOException {
        this( clients, clients_per_message_processing_thread, host, port );
        this.exe = exe;
    }

    // Call this to grab an instance
    public void
            req( final ThriftRequest req ) {
        final AsyncClient cli;
        synchronized ( instances ) {
            cli = instances.poll();
        }
        if ( cli != null ) {
            if ( exe != null ) {
                // Executor mode
                exe.execute( new Runnable() {

                    @Override
                    public void run() {
                        req.go( Thrift.this, cli );
                    }

                } );
            } else {
                // Thread bounce mode
                req.go( this, cli );
            }
            return;
        }
        // No clients immediately available
        requests.add( req );
    }

    private void ret( final AsyncClient cli ) {
        final ThriftRequest req;
        synchronized ( requests ) {
            req = requests.poll();
        }
        if ( req != null ) {
            if ( exe != null ) {
                // Executor mode
                exe.execute( new Runnable() {

                    @Override
                    public void run() {
                        req.go( Thrift.this, cli );
                    }
                } );
            } else {
                // Thread bounce mode
                req.go( this, cli );
            }
            return;
        }
        // We did not need this immediately, hold onto it
        instances.add( cli );

    }

}