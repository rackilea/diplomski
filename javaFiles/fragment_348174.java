class Mailbox {

    private final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<>();

    private final Thread mReceiverThread = new Thread(() -> {
        while (true) {
            try {
                Runnable job = mQueue.take();
                job.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public Mailbox() {
        mReceiverThread.start();
    }

    public void submitMsg(Runnable msg) {
        try {
            mQueue.put(msg);
        } catch (InterruptedException e) {
            // TODO exception handling; rethrow wrapped in unchecked exception here in order to allow for use of lambdas.
            throw new RuntimeException(e);
        }
    }

    public void ensureMailboxThread(Object target) {
        if (Thread.currentThread() != mReceiverThread) {
            throw new RuntimeException("operations on " + target + " are confined to thread " + mReceiverThread);
        }
    }
}

class A {

    // Example use
    public static void main(String[] args) {
        Mailbox a1Mailbox = new Mailbox();
        Mailbox a2Mailbox = new Mailbox();
        A a1 = new A(a1Mailbox);
        A a2 = new A(a2Mailbox);
        // Let's send something to a1 and have it send something to a2 if a certain condition is met.
        // Notice that there is no explicit sender:
        // If you wish to reply, you "hardcode" the reply to what you consider the sender in the Runnable's run().
        a1Mailbox.submitMsg(() -> {
            if (a1.calculateSomething() > 3.0) {
                a2Mailbox.submitMsg(() -> a2.doSomething());
            } else {
                a1.doSomething();
            }
        });
    }

    private final Mailbox mAssociatedMailbox;

    public A(Mailbox mailbox) {
        mAssociatedMailbox = mailbox;
    }

    public double calculateSomething() {
        mAssociatedMailbox.ensureMailboxThread(this);
        return 3 + .14;
    }

    public void doSomething() {
        mAssociatedMailbox.ensureMailboxThread(this);
        System.out.println("hello");
    }

}