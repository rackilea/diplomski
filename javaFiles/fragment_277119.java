public class MySessionManager extends StandardManager {

    @Override
    protected synchronized String generateSessionId() { 
        String sessionId = <Your session id generation algo>;
        return sessionId;
    }
}