public synchronized int size(){
    ClientSession coreSession = null;
    int count = 0;
    try {
        coreSession = sf.createSession(false, false, false);
        ClientSession.QueueQuery result;
        result = coreSession.queueQuery(new SimpleString(queueName));
        count = result.getMessageCount();
    } catch (HornetQException e) {
        e.printStackTrace();
    } finally {
        if (coreSession!= null ){
            try {
                coreSession.close();
            } catch (HornetQException e) {
                e.printStackTrace();
            }
        }
    }
    return count;
}