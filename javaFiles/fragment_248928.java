import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class PubSubMiddleware {

    private Map<String, Set<Subscriber>> subscriberMap = new Hashtable<String, Set<Subscriber>>();
    private Map<String, Set<CommandListener>> registeredInstanceMap = new Hashtable<String, Set<CommandListener>>();


    static PubSubMiddleware singletonInstance;

    public static PubSubMiddleware getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PubSubMiddleware();
        }
        return singletonInstance;
    }

    public void subscribe(Subscriber s, String eventSignature) {

        registerNewSubscriber(s, eventSignature);
    }

    public void publish(String eventName, Object arg) {

        Set<Subscriber> subscriberEventSet = getSubscribersForEvent(eventName);

        if (subscriberSet != null) {
            for (Subscriber s : subscriberSet) {
                s.notifyReceived(eventName, arg);
            }
        }

    }
    private void registerNewSubscriber(Subscriber s, String eSig) {

    if (subscriberMap.containsKey(eSig)) {

            Set<Subscriber> tempSet = subscriberMap.get(eSig);

            tempSet.add(s);
        } else {
            Set<Subscriber> newSet = new HashSet<Subscriber>();
            newSet.add(s);
            subscriberMap.put(eSig, newSet);
        }
    }

    private Set<Subscriber> getSubscribersForEvent(String eventSignature) {
        return subscriberMap.get(eventSignature);
    }

    // Request-Response

    public Object sendCommand(String methodName, Object arg) {

        Set<CommandListener> registeredInstanceSet = getInstanceForCommand(methodName);

        if (registeredInstanceSet != null) {
            for (CommandListener s : registeredInstanceSet) {
                return s.commandReceived(methodName, arg);
            }
        }
        return null;
    }

    private Set<CommandListener> getInstanceForCommand(String methodName) {
        return registeredInstanceMap.get(methodName);
    }

    private void registerNewInstance(CommandListener s, String listnerSignature) {


        if (registeredInstanceMap.containsKey(listnerSignature)) {
            Set<CommandListener> tempSet = registeredInstanceMap
                    .get(listnerSignature);
            tempSet.add(s);
        } else {
            Set<CommandListener> newSet = new HashSet<CommandListener>();
            newSet.add(s);
            registeredInstanceMap.put(listnerSignature, newSet);
        }
    }

    public void registerInstance(CommandListener s, String listnerSignature) {
        registerNewInstance(s, listnerSignature);
    }

}