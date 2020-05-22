new BaseClass () {
    List<String> strings = createInitialList();
    private List<String> createInitialList () {
        List<String> a = new ArrayList<String>();
        a.add("first");
        a.add("second");
        return a;
    }
}