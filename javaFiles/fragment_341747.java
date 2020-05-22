try {
    Object rpcRVal = client.execute( "weblogUpdates.extendedPing", params );
    if(rpcRVal instanceof Map) {
        Object flError = ((Map) rpcRVal ).get("flerror");
        if(flError != null && flError instanceof Boolean) {
            return ((Boolean) flError).booleanValue());        
        }
    }
    return true;
} catch(XmlRpcException e) ...