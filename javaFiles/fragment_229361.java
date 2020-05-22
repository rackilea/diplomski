public static void main(String[] args) throws ParseException {
    String[] values = new String[] {"Some item", "another item", "1 last more", "nevermind", "this is different"};
    System.out.println("Before: " + Arrays.toString(values));
    Arrays.sort(values, new Comparator<String>() {
        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }
    });
    System.out.println("After: " + Arrays.toString(values));
}