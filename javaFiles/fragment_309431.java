public static class FactoryWithArgsMaker {
    public static List<FactoryWithArgs> makeNew(int start, int end) {
        List<FactoryWithArgs> list = new ArrayList();
        for (int i = 0; i <= end; i++) {
            list.add(new FactoryWithArgs(i));
        }
        return list;
    }
}