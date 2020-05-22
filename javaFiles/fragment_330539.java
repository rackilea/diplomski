public static void main(String args[]) {
    Map<String, Object> modifiableMap = Maps.newHashMap();
    Map<String, Object> unmodifiableMap = Collections.unmodifiableMap(modifiableMap);
    List<Runner> runners;
    forEach(Runner runner: runners) {
        Object obj = runner.run(unmodifiableMap);
        modifiableMap.put(runner.name(), obj);
    }
}