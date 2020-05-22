try {
     client.execute( "weblogUpdates.extendedPing", params );
} catch(XmlRpcException e) {
    //check the code of the rpc exception as shown below,
    //log the error, or perhaps rethrow it?
    return false;
}