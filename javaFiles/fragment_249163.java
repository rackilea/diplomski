public static Comparator<MyEntry> ValueComparator = new Comparator<MyEntry>() {

    public int compare(MyEntry value1, MyEntry value2) {

        double rfirst = value1.rank;
        double rsecond = value2.rank;

        double dfirst = value1.dist;
        double dsecond = value2.dist;

        if (rsecond != rfirst) {
            return rsecond < rfirst?-1:1;
        } 
        else if(dsecond!=dfirst){
            return dsecond < dfirst ?-1:1;
        }
        return 0;

    }
}