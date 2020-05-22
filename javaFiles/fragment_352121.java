public class CriticalSections {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void mainMethod(boolean b) {
        if (b) {
            method1();
        } else {
            criticalMethod();
            method2();
        }
    }

    private void criticalMethod() {
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            System.out.println("in criticalMethod");
        } finally {
            writeLock.unlock();
        }
    }

    private void method1() {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            System.out.println("in method1");
        } finally {
            readLock.unlock();
        }
    }

    private void method2() {
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            System.out.println("in method2");
        } finally {
            readLock.unlock();
        }
    }
}