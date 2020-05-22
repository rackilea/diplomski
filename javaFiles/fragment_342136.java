Collections.sort(student, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        if (o1 == null) {
            return o2 == null ? 0 : -1;
        } else if (o2 == null) {
            return 1;
        }
        String[] o1Arr = o1.split(", ");
        String[] o2Arr = o2.split(", ");
        return o1Arr[1].compareTo(o2Arr[1]);
    }
});
System.out.println(student);