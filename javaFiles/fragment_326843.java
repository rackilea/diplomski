public class TestPhantomRefQueue {

    public static void main(String[] args)
            throws InterruptedException {

        Object obj = new Object();
        final ReferenceQueue queue = new ReferenceQueue();

        final WeakReference pRef =
                new WeakReference(obj, queue);

        obj = null;

        new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Awaiting for GC");

                    while (true) {
                        if (isRefernceCollected(pRef)) {
                           Thread.sleep(100);
                            break;
                        }
                    }
                    System.out.println("Referenced GC'd");
                    System.out.println(pRef.get());


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            protected boolean isRefernceCollected(final WeakReference pRef) {
                return pRef.get() == null;
            }
        }).start();

        // Wait for 2nd thread to start
        Thread.sleep(2000);

        System.out.println("Invoking GC");
        System.gc();
    }
}