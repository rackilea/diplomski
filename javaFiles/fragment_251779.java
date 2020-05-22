List<String> al = Arrays.asList("book.chap.subs1-0.3.4-1.txt",
            "book.chap.subs1-0.3.4-6.txt",
            "book.chap.subs1-0.5.4-1.txt",
            "book.chap.subs1-7.3.4-1.txt",
            "book.chap.subs1-0.3.6-1.txt",
            "book.chap.subs1-0.6.4-1.txt",
            "book.chap.subs2-0.3.8-1.txt");

Collections.sort(al, new Comparator<String>() {

    /**
     * Retrieve version numbers for a fileName
     * return int[]
     */
    private int[] getNumbers(String fileName) {
        Pattern p = Pattern.compile("book\\.chap\\.subs([0-9]+)-([0-9]+)\\.([0-9]+)\\.([0-9]+)-([0-9]+)\\.txt");
        int[] numbers = new int[5];
        Matcher m = p.matcher(fileName);
        if (m.find()) {
            for (int i = 1; i <= 5; i++) {
                String n = m.group(i);
                numbers[i - 1] = Integer.parseInt(m.group(i));
            }
        }
        return numbers;
    };

    @Override
    public int compare(String s1, String s2) {
        int[] n1 = getNumbers(s1);
        int[] n2 = getNumbers(s2);

        for (int i = 0; i < 5; i++) {
            if (n1[i] > n2[i]) {
                return 1;
            } else if (n1[i] < n2[i]) {
                return -1;
            }
        }
        return 0;
    }
});

for (int i = 0, len = al.size(); i < len ; i++){
    System.out.println(al.get(i));
}