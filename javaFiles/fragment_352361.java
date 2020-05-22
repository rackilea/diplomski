public static void main(String[] args) {
        List<AbstractMap.SimpleEntry<String, Integer>> entries = new ArrayList<>();

        entries.add(new AbstractMap.SimpleEntry<String, Integer>("C", 20));
        entries.add(new AbstractMap.SimpleEntry<>("C++", 10));
        //...

        Comparator<AbstractMap.SimpleEntry<String, Integer>> simpleEntryComparator = Comparator.<AbstractMap.SimpleEntry<String, Integer>, String>comparing(AbstractMap.Entry::getKey).thenComparingInt(AbstractMap.SimpleEntry::getValue);
        entries.sort(simpleEntryComparator);
        entries.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
}