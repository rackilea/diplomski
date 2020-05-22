private static class DoSubmitAccumulativeRunnable
     extends AccumulativeRunnable<Runnable> implements ActionListener {
    private final static int DELAY = (int) (1000 / 30);
    @Override
    protected void run(List<Runnable> args) {
        for (Runnable runnable : args) {
            runnable.run();
        }
    }
    @Override
    protected void submit() {
        Timer timer = new Timer(DELAY, this); // <-----
        timer.setRepeats(false);
        timer.start();
    }
    public void actionPerformed(ActionEvent event) {
        run(); // <-----
    }
}