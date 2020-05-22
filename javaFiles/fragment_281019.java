public class Dispatcher {

    private Map<String, ActionHandler> actionHandlerMap = new HashMap<String, ActionHandler>();

    public void perform(String action) {
        ActionHandler handler = actionHandlerMap.get(action);

        if (null == handler) {
            // no handler - throw an exception?
        }

        handler.execute();
    }

    public void addActionHandler(ActionHandler handler) {
        actionHandlerMap.put(handler.getAction(), handler);
    }

}

public interface ActionHandler {

    public String getAction();
    public void execute();

}