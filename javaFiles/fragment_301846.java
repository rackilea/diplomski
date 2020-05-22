class Container {
    private Map<String, List<?>> lists = new HashMap<>();

    private List<TypeOne> first = ...;
    private List<TypeTwo> second = ...;

    public Container() {
        lists.put("type1", first);
        lists.put("type2", second);
    }

    public int count(String type) {
        return lists.get(type).size();
    }
}