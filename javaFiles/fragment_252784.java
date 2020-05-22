// Little helper class:
class RPCResult<T>{
     private final T result;
     private final Exception ex;
     private final long id;

     public RPCResult( long id, T result, Exception ex ){
        // TODO set fields
     }

     // TODO getters

     public boolean hasError(){ return null != this.ex; }
} 


public Object xmlRpcMethod() {
    final BlockingQueue<RPCResult> pipe = new ArrayBlockingQueue<RPCResult>(1);
    XMLRPCCallback listener = new XMLRPCCallback() {
        public void onResponse(long id, final Object result) {
            // Do something
            pipe.put( new RPCResult<Object>(id, result, null) );
        }

        public void onError(long id, final XMLRPCException error) {
            // Do something
            pipe.put( new RPCResult<Object>(id, null, error) );
        }

        public void onServerError(long id, final XMLRPCServerException error) {
            Log.e(TAG, error.getMessage());
            pipe.put(new RPCResult<Object>(id, null, error));
        }
    };

    XMLRPCClient client = new XMLRPCClient("<url>");
    long id = client.callAsync(listener, "<method>");
    RPCResult result = pipe.take(); // blocks until there is an element available 
    // TODO: catch and handle InterruptedException!
    if( result.hasError() ) throw result.getError(); // Relay Exceptions - do not swallow them!
    return result.getResult();
}