Runnable runnable = new Runnable() {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        int i = 1;
        int j = 0;
        System.out.println(i / j);
    }
};
WrapperRunnable wrapperRunnable = new WrapperRunnable(runnable);
executor.execute(wrapperRunnable);