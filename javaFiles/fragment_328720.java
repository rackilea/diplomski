public interface Processable {
    public void process();
}

public class BarMock implements Processable {
    private MyClass clazz;
    private boolean called;

    public BarMock(MyClass clazz) {
        this.clazz = clazz;
        called = false;
    }

    @Override
    public void process() {
        // you can assertTrue(clazz.isRunning()) here, if required
        called = true;
        clazz.stop();
    }

    public boolean isCalled() {
        return called;
    }
}

public class MyClass implements Runnable {

    boolean running;

    public void run() {
        // foo is injected from the outside
        foo.start();
        work();
        foo.end();
    }

    public void work() {
        running = true;
        while (running) { // main loop
            bar.process(); // bar is injected from the outside
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}