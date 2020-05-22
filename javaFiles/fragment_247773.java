private class Task implements Runnable {

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
private Future<?> scheduledTaskHandle;

private class Listener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (scheduledTaskHandle != null && !scheduledTaskHandle.isDone()) {
            scheduledTaskHandle.cancel(false);
        }
        scheduledTaskHandle = executorService.schedule(new Task(), 1, TimeUnit.SECONDS);
    }
}