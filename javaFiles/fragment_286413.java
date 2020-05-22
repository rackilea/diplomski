public final Comparator<String> ID_IGN_CASE_COMP = new Comparator<String>() {

    public int compare(String s1, String s2) {
        int result = s1.compareToIgnoreCase(s2);
        if( result == 0 )
            result = s1.compareTo(s2);
        return result;
    }
};