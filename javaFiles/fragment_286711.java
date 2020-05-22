List<String> authors = new ArrayList<>(Arrays.asList("Unknown", "Hodor", "Jon Snow",
        "Sir Jamie Lannister"));
Collections.sort(authors, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        String[] left = o1.split("\\s+");
        String[] right = o2.split("\\s+");
        return left[left.length - 1].compareTo(right[right.length - 1]);
    }
});
System.out.println(authors);