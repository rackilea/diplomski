@Override
    public void preRestart(Throwable reason) {
        out.println("supervisor is restarting me!");
    }

    @Override
    public void postRestart(Throwable reason) {
        out.println("supervisor restarted me.");
    }