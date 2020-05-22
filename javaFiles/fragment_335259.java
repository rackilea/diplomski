public static void main(String[] args) {
    List<String> list = Arrays.asList("string", "sdkj");
    for (String s : list) {
        System.out.println(s + "=" + s.hashCode());
    }
    Collections.sort(list, new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            return o1.hashCode() - o2.hashCode();
        }
    });
    System.out.println("After Sorting");
    for (String s : list) {
        System.out.println(s + "=" + s.hashCode());
    }
}