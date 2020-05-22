public int compareTo(Task t1) {
    Integer csize = new Integer(t1.size);  // get t1's size
    int cmp = csize.compareTo(t1.size);  // ???? compare with t1's size ???

    return cmp;
}