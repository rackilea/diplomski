private final ThreadFactory threadFactory;
private final Thread deletethirdpartyClassThread;

public YourClass(ThreadFactory threadFactory) {
    this.threadFactory = threadFactory;
    deletethirdpartyClassThread = threadFactory.newThread(new Runnable(){
        @Override
        public void run()
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOG.error(e.getMessage(), e);
            }
            final String threadName = "deletethirdpartyClass:" + myId;
            Thread.currentThread().setName(threadName);
            m_thirdpartySvc.deleteObject(myId);
        }
    });
}