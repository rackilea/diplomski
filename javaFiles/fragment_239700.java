public class MyApplicationEventListener implements ApplicationEventListener {

    private volatile int requestCount = 0;

    @Override
    public void onEvent(ApplicationEvent event) {
        switch (event.getType()) {
            case INITIALIZATION_FINISHED:
                System.out.println("Application was initialized.");
                break;
            case DESTROY_FINISHED:
                System.out.println("Application was destroyed.");
                break;
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        requestCount++;
        System.out.println("Request " + requestCount + " started.");

        // return the listener instance that will handle this request.
        return new MyRequestEventListener(requestCnt);
    }
}