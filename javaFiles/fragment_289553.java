class MyComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.substring(0, 1).compareTo(s2.substring(0,1)) < 0) {
            return -1;
        } else if (s1.substring(0, 1).compareTo(s2.substring(0,1)) > 0) {
            return 1;
        } else { //first char is equal
            if(Integer.parseInt(s1.substring(1, s1.length())) < Integer.parseInt(s2.substring(1, s2.length()))) {
                return -1;
            } else if (Integer.parseInt(s1.substring(1, s1.length())) > Integer.parseInt(s2.substring(1, s2.length()))) {
                return 1;
            }
        }
        return 0;
    }
}