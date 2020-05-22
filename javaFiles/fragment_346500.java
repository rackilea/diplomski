public void doSomething() throws Exception {
    boolean success = false;
    Exception failureException = null;
    for (Server server : Servers.values()) {
        try {
            doSomethingToServer(server);
            success = true;
        } catch (Exception e) {
            if (failureException == null)
                failureException = e;
            else
                failureException.addSuppressed(e);
        }
    }
    if (! success && failureException != null)
        throw failureException;
}