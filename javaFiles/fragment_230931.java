public class MyEvaluator extends ContextAwareBase
                         implements EventEvaluator<ILoggingEvent> {

    private String name;
    private boolean started;
    private Set<String> requestIdsWithErrors = new HashSet<>();

    public boolean evaluate(ILoggingEvent event) {

        String requestId = MDC.get("requestId");
        boolean result = false;

        if (event.getLevel().levelInt >= Level.ERROR_INT)
            requestIdsWithErrors.add(requestId);

        Marker marker = event.getMarker();
        if (marker != null && marker.getName().equals("END_OF_REQUEST"))
            result = requestIdsWithErrors.remove(requestId);

        return result;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isStarted() { return started; }
    public void start() { started = true; }
    public void stop() { started = false; }
}