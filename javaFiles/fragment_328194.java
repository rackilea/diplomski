private Object storeDeletion(IMAPProtocol protocol, int startID, int endID) 
                                                   throws ProtocolException{
    String args = Integer.toString(startID) + ":" 
                  + Integer.toString(endID) 
                  + " +FLAGS" + " (\\Deleted)";
    Response[] r = protocol.command("STORE " + args, null);
    int notDeleted = 0;
    for (Response res : r) {
        // do something here with each response, but avoid last one (summary response) 
    }
    // dispatch remaining untagged responses
    protocol.notifyResponseHandlers(r);
    protocol.handleResult(r[r.length-1]);
    return "" + (r.length - notDeleted - 1);
}