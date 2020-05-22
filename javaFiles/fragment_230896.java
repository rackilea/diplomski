// this class supplies real Lock instances.
public class LockSupplier implements Supplier<Lock> {

    @Override
    public Lock get() {
        return new ReentrantLock();
    }

}

// this class supplies your mocked instances for your unit test.
public class MockLockSupplier implements Supplier<Lock> {

    private Lock mockedLock;

    public MockLockSupplier(Mockery context) {
        mockedLock = context.mock(Lock.class);
    }

    @Override
    public Lock get() {
        return mockedLock;
    }

}