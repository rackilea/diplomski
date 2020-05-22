List<String> al = Arrays.asList("45", "186", "185", "55", "51", "51", //
        "22", "78", "64", "26", "49", "21");
Collections.sort(al, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
    }
});
System.out.println(al);