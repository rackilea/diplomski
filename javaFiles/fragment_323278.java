public static void main(String[] args) {
    Map<String, String> brokenMap = new TreeMap<String, String> (new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    });

    brokenMap.put("a", "a");
    brokenMap.put("b", "b");
    System.out.println("size: " + brokenMap.size());
    System.out.println("content: " + brokenMap);
}