public static void main(String... args) {
    NavigableMap<String, Object> map = new TreeMap<String, Object>(new Comparator<String>() {
        final Pattern pattern = Pattern.compile("(\\d+)(.*)");

        @Override
        public int compare(String o1, String o2) {
            Matcher matcher1 = pattern.matcher(o1);
            Matcher matcher2 = pattern.matcher(o2);
            matcher1.find();
            matcher2.find();
            int cmp = Long.compare(Long.parseLong(matcher1.group(1)), Long.parseLong(matcher2.group(1)));
            if (cmp != 0)
                return cmp;
            return matcher1.group(2).compareTo(matcher2.group(2));
        }
    });

    map.put("1", "one");
    map.put("1A", "oneA");
    map.put("10", "ten");
    map.put("10AB", "tenAB");
    map.put("15", "fifteen");
    map.put("2", "two");
    map.put("2AB", "twoAB");
    map.put("2", "three");

    System.out.println(map.keySet());
}