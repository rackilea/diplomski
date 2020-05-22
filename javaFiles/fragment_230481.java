public class HazelcastTest {

    @Test
    public void test() {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();

        IExecutorService exec = instance.getExecutorService("exec");
        for (int i = 0; i < 100; i++) {
            exec.submit(new MyRunnable());
        }
    }

}

public class MyRunnable implements Runnable, Serializable {

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.err.println("threadId: " + threadId);
    }

}