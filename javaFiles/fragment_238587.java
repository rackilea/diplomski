@Override
public String processCall(RPCRequest rpcRequest) throws SerializationException {
    //your checks here, in case of error:
    //return RPC.encodeResponseForFailedRequest(null, new Exception("Invalid session"));
  // note that you'll have to use a serializable exception type here.

    return super.processCall(rpcRequest);
}