public Session getSession() {

    if (session == null) {
        try {
            CallableSession cs = new CallableSession(url, user, password, workspace);
            FutureTask<Session> future = new FutureTask<Session>(cs);
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(future);
            session = future.get(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS);

        } catch (InterruptedException ex) {
            Logger.getLogger(JackRabbitConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(JackRabbitConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(JackRabbitConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return session;
}