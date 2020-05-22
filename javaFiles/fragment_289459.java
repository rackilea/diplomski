private static final int MAX_CALLS = 10;
private static final int PER_INTERVAL = 60000; // 60s
private static final int MAX_WAIT = 2000; // 2s

private RequestThrottler _throttler = new RequestThrottler(MAX_CALLS, PER_INTERVAL);
private SomeWebService _service = new SomeWebService();

public void callService() {
    throttler.startRequest(MAX_WAIT);
    _service.call();
}