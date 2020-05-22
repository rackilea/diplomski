private class TerminalNameCache {
    private final Map<Integer, String> cache = new ConcurrentHashMap<>();

    private String getTerminalName(Integer id) {
        return cache.computeIfAbsent(id,
                id2 -> ParentControllerClass.this.getTerminalName(id2));
    }
}