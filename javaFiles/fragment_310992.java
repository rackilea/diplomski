public class ActionsManager {
    private final Map<String, Action> actions;
    private final Map<User, Set<String>> enabledActions;
    public Action get(String id);
    public void register(String id, Action action);
    public void deregister(String id);
    public boolean isEnabled(User user, Action action);
}