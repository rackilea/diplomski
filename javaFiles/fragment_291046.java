class NameAndPhoneComparator implements Comparator<String[]> {
    public int compare(String[] o1, String[] o2) {
        int c = o1[0].compareTo(o2[0]);
        if (c != 0) return c;
        return o1[1].compareTo(o2[1]);
    }
}