private static class SynchronizedMapInstanceCreator<K, V> implements
        InstanceCreator<Map<K, V>> {

    @Override
    public Map<K, V> createInstance(final Type type) {
        return java.util.Collections.synchronizedMap(new HashMap<K, V>());
    }
} 

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    String json_alert_state_manager = "{\"fallBelows\":[[{\"code\":\"hello\"},1370359852472]],\"riseAboves\":[[{\"code\":\"world\"},1370359852472]]}";
    // READ
    {
        Gson gson = new GsonBuilder().registerTypeAdapter(
            new TypeToken<Map<Code, Long>>() {}.getType(), 
            new SynchronizedMapInstanceCreator<Code, Long>()).create();
        AlertStateManager alertStateManager = gson.fromJson(json_alert_state_manager, AlertStateManager.class);
        alertStateManager.debug();
    }
}