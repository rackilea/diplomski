public void doSomething() throws IOException, GeneralSecurityException {
    boolean success = false;
    Exception failureException = null;
    for (Server server : Servers.values()) {
        try {
            doSomethingToServer(server);
            success = true;
        } catch (RuntimeException | IOException | GeneralSecurityException e) {
            if (failureException == null)
                failureException = e;
            else
                failureException.addSuppressed(e);
        }
    }
    if (! success && failureException != null) {
        if (failureException instanceof RuntimeException)
            throw (RuntimeException) failureException;
        if (failureException instanceof IOException)
            throw (IOException) failureException;
        if (failureException instanceof GeneralSecurityException)
            throw (GeneralSecurityException) failureException;
        throw new RuntimeException("Oops! Unexpected exception type: " + failureException, failureException);
    }
}

private void doSomethingToServer(Server server) throws IOException, GeneralSecurityException {
    // code here
}