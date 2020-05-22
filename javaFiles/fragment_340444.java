public synchronized int size(){
    ClientSession session;
    try {
        session = sf.createSession(false, false, false);
        ClientRequestor requestor = new ClientRequestor(session, "hornetq.management");
        ClientMessage m = session.createMessage(false);
        ManagementHelper.putAttribute(m, "core.queue." + queueName, "messageCount");
        ClientMessage reply = requestor.request(m);
        int count = (Integer) ManagementHelper.getResult(reply);
        return count;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}