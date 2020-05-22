public class ServiceTest {
    private ServiceCallback mServiceCallback;
    class SomeClassTest extends SomeClass {
        @Override
        registerCallback(ServiceCallback callback) {
            mServiceCallback = callback;
            super.registerCallback(callback);
        }
    }
}