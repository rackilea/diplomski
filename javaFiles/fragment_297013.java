Collections.sort(stringList, new Comparator < String[] > () {
    public int compare(String[] x1, String[] x2) {
        if (x1.length > sortNum && x2.length > sortNum) {
            return x2[sortNum].compareTo(x1[sortNum]); 
        }
        if (x1.length > sortNum) {
            return 1;
        }
        if (x2.length > sortNum) {
            return -1;
        }
        return x2.length - x1.length;
    }
});