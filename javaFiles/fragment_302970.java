public static native void setupNativeRactRPCServiceCalls(ReactRPCServiceAccessor reactRpc)/*-{
    $wnd.reactRpcService = function(callback){
        reactRpc.@com.myproject.ReactRPCServiceAccessor::dispatchRPCRequest(Lcom/google/gwt/core/client/JavaScriptObject;)(callback);
    }
}-*/;

 private void dispatchRPCRequest(final JavaScriptObject callback ) {
...retrieve JSON data
}