class WaitReleaseTest implements Runnable {
    Object lockA, lockB;
    public WaitReleaseTest(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " attempting to acquire lockA");
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()
                    + " attempting to acquire lockB");
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()
                        + " holds lockA = " + Thread.holdsLock(lockA));
                System.out.println(Thread.currentThread().getName()
                        + " holds lockB = " + Thread.holdsLock(lockB));
                try {
                    lockB.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        Object o2=new Object();
        new Thread(new WaitReleaseTest(o1,o2)).start();
        TimeUnit.MILLISECONDS.sleep(500);
        new Thread(new WaitReleaseTest(o1,o2)).start();
    }
}