new Comparator<Map.Entry<List<Item>, Double>>() {
    @Override
    public int compare(Entry<List<Item>, Double> o1,
                       Entry<List<Item>, Double> o2) {

        int diff = o2.getKey().size() - o1.getKey().size();
        return diff != 0 ? diff :
            System.identityHashCode(o2.getKey()) -
                System.identityHashCode(o1.getKey());
    }
};