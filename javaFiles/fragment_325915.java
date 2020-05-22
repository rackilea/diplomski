public static <K,V> InstanceCreator<Map<K, V>> newCreator() {
    return new InstanceCreator<Map<K, V>>() {
        @Override
        public Map<K, V> createInstance(Type type) {
            return new HashMap<K, V>();
        }
    };
}