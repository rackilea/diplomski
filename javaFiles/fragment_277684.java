String sessionId = "";
    client = new XMLRPCClient(URL);
    try {
        sessionId = (String)client.call("login", "tester", "tester");
        Log.d("MY_XMLRPC_SUCCESS_SESSION_ID", sessionId);
    }
    catch (XMLRPCException e) {
        Log.d("MY_XMLRPCException_MSG", e.getMessage());
    }

    Object[] customerOrderList = null;           
    try {
        customerOrderList = (Object[])client.callEx("call", new Object[]{sessionId, "sales_order.list"});
    } catch (Exception e) {
        Log.d("APP_INFO", "Exception: " + e.getMessage());
    }