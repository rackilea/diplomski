public class FilterConfig {

    private Map<Integer, Set<String>> acceptedContextsByPort = new ConcurrentHashMap<>();

    public void addNewPortConfig(int port, String allowedContextUrl) {
        if(port > 0 && allowedContextUrl != null) {
            Set<String> set = acceptedContextsByPort.get(port);
            if (set == null) {
                set = new HashSet<>();
            }
            set = new HashSet<>(set);
            set.add(allowedContextUrl);
            acceptedContextsByPort.put(port, set);
        }
    }

    public void removePortConfig(int port) {
        if(port > 0) {
            acceptedContextsByPort.remove(port);
        }
    }

    public Map<Integer, Set<String>> getConfig(){
        return acceptedContextsByPort;
    }
}