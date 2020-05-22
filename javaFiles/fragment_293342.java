class MyTask implements Runnable {
    private final Semaphore permissionToDie = new Semaphore(0);

    public void grantPermissionToDie() {
        permissionToDie.release();
    }

    @Override
    public void run() {
        doWhatever();
        permissionToDie.acquire();
    }
}